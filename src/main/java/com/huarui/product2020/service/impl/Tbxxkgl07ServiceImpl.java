package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbxxkgl07;
import com.huarui.product2020.mapper.Tbxxkgl07Mapper;
import com.huarui.product2020.service.ITbxxkgl07Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
@Service
public class Tbxxkgl07ServiceImpl extends ServiceImpl<Tbxxkgl07Mapper, Tbxxkgl07> implements ITbxxkgl07Service {

	@Autowired
	private Tbxxkgl07Mapper tbxxkgl07Mapper;
	
	/**
	 * 学习卡激活记录
	 * @param page
	 * @param param
	 * @return
	 */
	@Override
	public List queryActivationRecordList(IPage page, Map<String, Object> param) {
		return tbxxkgl07Mapper.queryActivationRecordList(page, param);
	}

	/**
	 * 学习卡激活记录
	 * @param param
	 * @return
	 */
	@Override
	public List findActivationRecordList(Map<String, Object> param) {
		return tbxxkgl07Mapper.findActivationRecordList(param);
	}

	/**
	 * 学习卡激活绑定商品,更新状态
	 * @param entity
	 * @return
	 */
	@Override
	public boolean updateActivation(Tbxxkgl07 entity) {
		boolean boo = false;
		int update = tbxxkgl07Mapper.updateActivation(entity);
		if(0 < update) {
			boo = true;
		}
		return boo;
	}

	@Override
	public String addCoursePackage(Map param) {
		tbxxkgl07Mapper.addCoursePackage(param);
		return "SUCCESS";
	}
	
}
