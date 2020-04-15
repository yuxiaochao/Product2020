package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbwdkc02;
import com.huarui.product2020.mapper.Tbwdkc02Mapper;
import com.huarui.product2020.service.ITbwdkc02Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
@Service
public class Tbwdkc02ServiceImpl extends ServiceImpl<Tbwdkc02Mapper, Tbwdkc02> implements ITbwdkc02Service {
    @Override
    public List<Tbwdkc02> findbyCourseList(Tbwdkc02 tbwdkc02) {
    	List<Tbwdkc02> list = new ArrayList<Tbwdkc02>();
    	
    	List<Tbwdkc02> list02 = baseMapper.findbyCourseList(tbwdkc02);
    	
    	for(Tbwdkc02 thisTbwdkc02 : list02) {
        	if(thisTbwdkc02 != null && 
        			(!"890".equals(thisTbwdkc02.getWdkc0203())  //不等于  “全真模拟中药学套包”
        					&& !"1119".equals(thisTbwdkc02.getWdkc0203())  // 不等于  “2019模拟考场中药学”
					)
			) {
        		list.add(thisTbwdkc02);
			}
        }
    	
        return list;
    }
}
