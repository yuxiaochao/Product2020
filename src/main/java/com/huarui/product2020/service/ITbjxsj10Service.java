package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj10;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjxsj10Service extends IService<Tbjxsj10> {

	List<Tbjxsj10> findByPage(Req req);

	String edit(Req req);
	
	/**
	 * 案例分析弹窗课程
	 * @param req
	 * @return
	 */
	IPage findAllCaseCourse(Req req);
	
}
