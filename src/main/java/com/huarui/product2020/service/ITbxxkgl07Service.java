package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbxxkgl07;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
public interface ITbxxkgl07Service extends IService<Tbxxkgl07> {

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
	boolean updateActivation(Tbxxkgl07 entity);

	/**
     * 我的课程——激活后加入课程
     */
    public String addCoursePackage(Map param);
	
}
