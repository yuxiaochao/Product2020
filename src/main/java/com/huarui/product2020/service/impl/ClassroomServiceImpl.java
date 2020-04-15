package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Classroom;
import com.huarui.product2020.entity.ClassroomPic;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.mapper.ClassroomMapper;
import com.huarui.product2020.mapper.ClassroomPicMapper;
import com.huarui.product2020.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教室资源 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements IClassroomService {

    
    @Autowired
    private ClassroomMapper classroomMapper;
    
    @Autowired
    private ClassroomPicMapper classroomPicMapper;
    
    @Override
    public Page<Classroom> findList(IPage<Classroom> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findList(page, paramMap));
        return page;
    }

    @Override
    @Transactional
    public ResultEntity saveOrUpdate(Req req) {
        ResultEntity result = new ResultEntity();
        Map<?, ?> parameterMap = req.getParameterMap();
        String jsonString = JSON.toJSONString(parameterMap);
        Classroom classroom = JSON.parseObject(jsonString,Classroom.class);
        
        // 上传图片的地址
        String imageUrl = req.getString("clpi004");
        
        if(ThreadUtils.getRTex().isEmpty(classroom.getClas001())) {
            // 插入
            classroom.setClas001(ThreadUtils.getRTex().getUUID());
            // 归属单位
            classroom.setClas013(req.getUserManagerOrganId());
            classroom.setClas014(req.getUserId());
            classroom.setClas015(new Date());
            classroom.setClas016(new Date());
            classroomMapper.insert(classroom);
            
            ClassroomPic classroomPic = new ClassroomPic();
            classroomPic.setClpi001(ThreadUtils.getRTex().getUUID());
            classroomPic.setClpi002(classroom.getClas001());
            classroomPic.setClpi003(null);
            classroomPic.setClpi004(imageUrl);
            classroomPicMapper.insert(classroomPic);
        } else {
            // 更新
            classroom.setClas016(new Date());
            classroomMapper.updateById(classroom);

            EntityWrapper<ClassroomPic> ew = new EntityWrapper<ClassroomPic>();
            ew.eq("clpi002", classroom.getClas001());
            List<ClassroomPic> list = classroomPicMapper.selectList(ew);
            if(list.size() > 0) {
                ClassroomPic classroomPic = list.get(0);
                classroomPic.setClpi004(imageUrl);
                classroomPicMapper.updateById(classroomPic);
            } else {
                ClassroomPic classroomPic = new ClassroomPic();
                classroomPic.setClpi001(ThreadUtils.getRTex().getUUID());
                classroomPic.setClpi002(classroom.getClas001());
                classroomPic.setClpi003(null);
                classroomPic.setClpi004(imageUrl);
                classroomPicMapper.insert(classroomPic);
            }
            
        }
        return result;
    }

    @Override
    public Classroom findDetailById(String id) {
        return baseMapper.findDetailById(id);
    }

    @Override
    public Page<Classroom> findClassroomList(IPage<Classroom> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findClassroomList(page, paramMap));
        return page;
    }
	
}
