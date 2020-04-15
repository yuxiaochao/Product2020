package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.RedisUtil;
import com.huarui.product2020.entity.Tblere01;
import com.huarui.product2020.mapper.Tblere01Mapper;
import com.huarui.product2020.service.ITblere01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
@Service
public class Tblere01ServiceImpl extends ServiceImpl<Tblere01Mapper, Tblere01> implements ITblere01Service {
	
	@Autowired
    private RedisUtil redisService;

	@Override
	public List<Tblere01> selectUserProgressCourse(String lere0103) {
		// 用户id   lere0103
		List<Tblere01> tblere01List = new ArrayList<Tblere01>();
		String redisKey = "userProgressCourse_" + lere0103;
    	if(!redisService.exists(redisKey)) {
    		//查询用户课程进度
    		EntityWrapper<Tblere01> ew = new EntityWrapper<Tblere01>();
    		ew.where("LERE0103={0}", lere0103);
    		tblere01List = baseMapper.selectList(ew);
    		
    		setUserProgressCourse(lere0103, tblere01List);
    	}else {
    		tblere01List = (List)redisService.lget(redisKey);
    	}
		
		return tblere01List;
	}
	
	public void setUserProgressCourse(String userid, List<Tblere01> tblere01List) {
		String redisKey = "userProgressCourse_" + userid;
		redisService.setListCache(redisKey, (List)tblere01List, RedisUtil.SerializerMode.SERIALIZATION, TimeUnit.MINUTES.toSeconds(30));
	}
	
}
