package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTGrouppool;
import com.huarui.product2020.mapper.HrswTGrouppoolMapper;
import com.huarui.product2020.service.IHrswTGrouppoolService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-01-10
 */
@Service
public class HrswTGrouppoolServiceImpl extends ServiceImpl<HrswTGrouppoolMapper, HrswTGrouppool> implements IHrswTGrouppoolService {

    @Override
    public Set<String> findGroupPool(String groupId) {
        HrswTGrouppool hrswTGrouppool = selectById(groupId);
        if(hrswTGrouppool!=null){
            //更新拉取时间
            upDataGroupPool(hrswTGrouppool);
            String[] split = hrswTGrouppool.getGrpo004().split(",");
            return new HashSet<>(Arrays.asList(split));
        }
        return null;
    }

    @Override
    public Map<String, Set<String>> findGroupPoolAll() {
        List<HrswTGrouppool> hrswTGrouppools = selectList(new EntityWrapper<HrswTGrouppool>());
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        if(hrswTGrouppools!=null&&hrswTGrouppools.size()>0){
            for (HrswTGrouppool hrswTGrouppool : hrswTGrouppools) {
                //更新拉取时间
                upDataGroupPool(hrswTGrouppool);
                String[] split = hrswTGrouppool.getGrpo004().split(",");
                map.put(hrswTGrouppool.getGrpo001(), new HashSet<>(Arrays.asList(split)));
            }
        }
        return map;
    }

    @Async
    public void upDataGroupPool(HrswTGrouppool hrswTGrouppool){
        hrswTGrouppool.setGrpo003(new Date());
        updateById(hrswTGrouppool);
    }
}
