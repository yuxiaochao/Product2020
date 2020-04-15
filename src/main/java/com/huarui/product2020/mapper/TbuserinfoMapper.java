package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbuserinfo;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-02-19
 */
public interface TbuserinfoMapper extends BaseMapper<Tbuserinfo> {
	
	//查询个人资料
	Map<String, Object> selectMapForUserInfo(String webUserId);

}