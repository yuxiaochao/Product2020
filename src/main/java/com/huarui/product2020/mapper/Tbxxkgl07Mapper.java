package com.huarui.product2020.mapper;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbxxkgl07;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
public interface Tbxxkgl07Mapper extends BaseMapper<Tbxxkgl07> {

	/**
	 * 学习卡激活记录
	 * @param page
	 * @param param
	 * @return
	 */
	List queryActivationRecordList(IPage page, Map<String, Object> param);

	/**
	 * 学习卡激活记录
	 * @param param
	 * @return
	 */
	List findActivationRecordList(Map<String, Object> param);

	/**
	 * 学习卡激活绑定商品,更新状态
	 * @param entity
	 * @return
	 */
	int updateActivation(Tbxxkgl07 entity);

	
	public void addCoursePackage(Map param);

}