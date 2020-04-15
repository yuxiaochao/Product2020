package com.huarui.webSocket;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.utils.RText;
import com.huarui.common.utils.RedisUtil;
import com.huarui.product2020.entity.HrswTGrouppool;
import com.huarui.product2020.service.IHrswTGrouppoolService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 群组池
 */
@Component
public class GroupPool {
    @Autowired
    private RedisUtil _redisUtil;

    @Autowired
    private IHrswTGrouppoolService _groupPoolService;

    //redis存储唯一groupPool的key值
    private static final String _groupPoolKey = "huarui##groupPool";

    private Map<String, Set<String>> _groupPool = new HashMap<>();

    private final static Logger LOGGER = LoggerFactory.getLogger(GroupPool.class);

    /**
     * 包装获取GroupPool方法
     *
     * @param groupId    组池id
     * @param fromUserId 发送人id
     * @return Set<String>
     */
    public Set<String> getGroupPool(String groupId, String fromUserId) {
        Set<String> groupList = _getGroupPool(groupId);
        if (groupList != null && groupList.size() > 0) {
            groupList.remove(fromUserId);
        }else{
            groupList = new HashSet<>();
        }
        return groupList;
    }

    /**
     * 包装获取GroupPool方法
     *
     * @param groupId 组池id
     * @return Set<String>
     */
    public Set<String> getGroupPool(String groupId) {
        return _getGroupPool(groupId);
    }

    /**
     * 淡出的获取GroupPool的入口  处理具体的数据库更新操作
     * GroupPool三级缓存
     *
     * @param groupId 组池id
     * @return Set<String>
     */
    private Set<String> _getGroupPool(String groupId) {
        Set<String> groupList = new HashSet<>();
        try {
            //如果池中没有此groupId对应的数据则从redis中查询
            //判断缓存中是否有对应的value
            if (_redisUtil.exists(_groupPoolKey)) {
                Map<String, Set<String>> groupPool = _redisUtil.mget(_groupPoolKey);
                //判断缓存的groupPool中是否有groupId对应的值
                if (groupPool.get(groupId) == null || groupPool.get(groupId).size() == 0) {
                    //如果没有则从数据库中拉取
                    groupList = _groupPoolService.findGroupPool(groupId);
                    //数据库拉取完后存入redis缓存
                    if (groupList != null && groupList.size() > 0) {
                        setGroupPool(groupId, groupList);
                    } else {
                        //TODO 当前几个用户没有存在可用的会话
                        LOGGER.info("-------------没有获取到缓存1-------------");
                        return null;
                    }
                } else {
                    //如果有则判断群组中数量是否>0 如果大于0 则为正常数据
                    if (groupPool.get(groupId).size() > 0) {
                        LOGGER.info("-------------从redis获取缓存-------------");
                        groupList = groupPool.get(groupId);
                        //存到全局变量
                        if (this._groupPool == null) {
                            this._groupPool = new HashMap<>();
                        }
                        this._groupPool.put(groupId, groupList);
                    } else {
                        //从业务角度讲 不必从数据库中在拉取一遍  因为存缓存是在存数据库之前
                        //redis缓存及数据库移除
                        _redisUtil.delMapField(_groupPoolKey, groupId);
                        //数据库中移除本群组
                        _groupPoolService.deleteById(groupId);
                        LOGGER.info("-------------没有获取到缓存2-------------");
                        return null;
                    }
                }
            } else {//如果缓存中没有对应的
                //如果没有则从数据库中拉取
                groupList = _groupPoolService.findGroupPool(groupId);
                //数据库拉取完后存入redis缓存
                if (groupList != null && groupList.size() > 0) {
                    LOGGER.info("-------------从数据库获取缓存-------------");
                    setGroupPool(groupId, groupList);
                }
            }
        } catch (Exception e) {
            LOGGER.info("-------------群组池取值异常-----------");
            e.printStackTrace();
        }
        return groupList;
    }

    public void setGroupPool(String groupId, Set<String> groupList) {
        //存到全局变量
        if (this._groupPool != null) {
            this._groupPool.put(groupId, groupList);
        } else {
            this._groupPool = new HashMap<>();
        }
        //存入缓存
        if (_redisUtil.exists(_groupPoolKey)) {
            _redisUtil.addMap(_groupPoolKey, groupId, groupList);
        } else {
            _redisUtil.addMap(_groupPoolKey, this._groupPool);
        }
    }

    public void setGroupPool(Map<String, Set<String>> groupList) {
        //存到全局变量
        this._groupPool = groupList;
        //存入缓存
        _redisUtil.remove(_groupPoolKey);
        _redisUtil.setMap(_groupPoolKey, this._groupPool, 0);
    }

    /**
     * 单聊状态下用户未加入数据库中
     *
     * @param groupId    群组id
     * @param groupUsers 群组人员
     * @param creatUser  创建人
     */
    public void insertDatabase(String groupId, Set<String> groupUsers, String creatUser) {
        Object[] objects = groupUsers.toArray();
        String join = StringUtils.join(objects, ",");
        HrswTGrouppool hrswTGrouppool = new HrswTGrouppool();
        hrswTGrouppool.setGrpo001(groupId);
        hrswTGrouppool.setGrpo002(new Date());
        hrswTGrouppool.setGrpo003(new Date());
        hrswTGrouppool.setGrpo004(join);
        hrswTGrouppool.setGrpo005(creatUser);
        hrswTGrouppool.setGrpo006(_groupPoolKey);
        _groupPoolService.insert(hrswTGrouppool);
    }

    /**
     * 把用户存到池里（缓存池 数据池） 创建用户间的会话
     *
     * @param groupUsers 池中的全部人
     * @param creatUser  创建池的人
     */
    public String addGroupUsersToGroupPool(Set<String> groupUsers, String creatUser) {
        //生成  groupId
        String groupId = new RText().getUUID();
        //TODO 两者异步
        //先把用户放到redis中
        setGroupPool(groupId, groupUsers);
        //在吧用户放到数据库中
        insertDatabase(groupId, groupUsers, creatUser);
        return groupId;
    }

    /**
     * 把用户存到池里（缓存池 数据池） 创建用户间的会话
     *  @param groupUsers 池中的全部人
     * @param creatUser  创建池的人
     */
    public void addGroupUsersToGroupPool(Set<String> groupUsers, String creatUser, String groupId) {
        //TODO 两者异步
        //先把用户放到redis中
        setGroupPool(groupId, groupUsers);
        //在吧用户放到数据库中
        insertDatabase(groupId, groupUsers, creatUser);
    }

    /**
     * 添加单个用户到指定群组
     * @param groupId 群组id
     * @param userId 用户id
     */
    public void setGroupPool(String groupId, String userId) {
        //存到全局变量
        Set<String> strings;
        if (this._groupPool != null&&this._groupPool.get(groupId)!=null) {
            strings = this._groupPool.get(groupId);
        } else {
            this._groupPool = new HashMap<>();
            strings = new HashSet<>();
        }
        strings.add(userId);
        this._groupPool.put(groupId,strings);
        //存入缓存
        if (_redisUtil.exists(_groupPoolKey)) {
            _redisUtil.addMap(_groupPoolKey, groupId, strings);
        } else {
            _redisUtil.addMap(_groupPoolKey, this._groupPool);
        }
    }

    /**
     * 重置groupPool 更新为数据库最新
     */
    public void clear() {
        this._groupPool = new HashMap<>();
        _redisUtil.remove(_groupPoolKey);
        //存到全局变量
        this._groupPool = _groupPoolService.findGroupPoolAll();
        //存入缓存
        _redisUtil.addMap(_groupPoolKey, this._groupPool);
    }

    /**
     * 操作前验证
     */
    private void groupPoolVerification() {
        if (_redisUtil.exists(_groupPoolKey)) {
            this._groupPool = _redisUtil.mget(_groupPoolKey);
        } else {
            List<HrswTGrouppool> groupPools = _groupPoolService.selectList(new EntityWrapper<>());
            Map<String, Set<String>> groupList = new HashMap<>();
            for (HrswTGrouppool hrswTGrouppool : groupPools) {
                String[] split = hrswTGrouppool.getGrpo004().split(",");
                Set<String> staffsSet = new HashSet<>(Arrays.asList(split));
                groupList.put(hrswTGrouppool.getGrpo001(), staffsSet);
            }
            setGroupPool(groupList);
        }
    }


    /**
     * 删除一些groupId对应的全部数据---移除操作
     *
     * @param groupIds 群组id
     */
    public void deleteSomeAll(Set<String> groupIds) {
        //操作前验证
        groupPoolVerification();
        //移除
        for (String groupId : groupIds) {
            this._groupPool.remove(groupId);
            _redisUtil.delMapField(_groupPoolKey,groupId);
        }
        List<String> result = new ArrayList<>(groupIds);
        _groupPoolService.deleteBatchIds(result);
    }

    /**
     * 删除一些groupId对应的全部数据---移除操作
     *
     * @param groupIds 群组id
     */
    public void deleteSomeAll(String[] groupIds) {
        Set<String> staffsSet = new HashSet<>(Arrays.asList(groupIds));
        deleteSomeAll(staffsSet);
    }

    /**
     * 删除groupId对应的全部数据---移除操作
     *
     * @param groupId 群组id
     */
    public void deleteAll(String groupId) {
        //操作前验证
        groupPoolVerification();
        this._groupPool.remove(groupId);
        _redisUtil.delMapField(_groupPoolKey,groupId);
        _groupPoolService.deleteById(groupId);
    }

    /**
     * 从数据库删除groupId对应的某些用户---更新操作
     *
     * @param groupId    群组id
     * @param groupUsers 群组人员
     */
    public void deleteSomeUser(String groupId, Set<String> groupUsers) {
        //操作前验证
        groupPoolVerification();

        for (String groupUser : groupUsers) {
            //操作全局变量
            this._groupPool.get(groupId).remove(groupUser);
        }
        //操作redis
        _redisUtil.addMap(_groupPoolKey,groupId,this._groupPool.get(groupId));
        Object[] objects = this._groupPool.get(groupId).toArray();
        String join = StringUtils.join(objects, ",");
        //操作数据库
        HrswTGrouppool entity = new HrswTGrouppool();
        entity.setGrpo004(join);
        _groupPoolService.updateById(entity);
    }

    /**
     * 从数据库删除groupId对应的某些用户---更新操作
     *
     * @param groupId    群组id
     * @param groupUser 群组人员
     */
    public void deleteOneUserToDataBase(String groupId, String groupUser) {
        //操作前验证
        groupPoolVerification();
            //操作全局变量
        this._groupPool.get(groupId).remove(groupUser);
        //操作redis
        _redisUtil.addMap(_groupPoolKey,groupId,this._groupPool.get(groupId));
        Object[] objects = this._groupPool.get(groupId).toArray();
        String join = StringUtils.join(objects, ",");
        //操作数据库
        HrswTGrouppool entity = new HrswTGrouppool();
        entity.setGrpo004(join);
        _groupPoolService.updateById(entity);
    }

    /**
     * 从缓存中删除groupId对应的某个用户---临时群组更新操作
     *
     * @param groupId    群组id
     * @param groupUser 群组人员
     */
    public void deleteOneUserToCache(String groupId, String groupUser) {
        //操作前验证
        groupPoolVerification();
        //操作全局变量
        this._groupPool.get(groupId).remove(groupUser);
        //操作redis
        _redisUtil.addMap(_groupPoolKey,groupId,this._groupPool.get(groupId));
    }

    /**
     * 从数据库删除groupId对应的某些用户---更新操作
     *
     * @param groupId    群组id
     * @param groupUsers 群组人员
     */
    public void deleteSomeUser(String groupId, String[] groupUsers) {
        Set<String> staffsSet = new HashSet<>(Arrays.asList(groupUsers));
        deleteSomeUser(groupId, staffsSet);
    }

}
