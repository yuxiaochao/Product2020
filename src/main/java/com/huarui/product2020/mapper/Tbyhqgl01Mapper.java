package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbyhqgl01;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
public interface Tbyhqgl01Mapper extends BaseMapper<Tbyhqgl01> {

	/**
	 * 根据卡号、密码查询对应的信息 
	 */
	public Map<String,String> getCouponByCardAndPwd(@Param("yhqgl0303")String yhqgl0303,@Param("yhqgl0304")String yhqgl0304);
}