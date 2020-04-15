package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbpxb02;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbpxb02Service extends IService<Tbpxb02> {

	List<Tbpxb02> findByPage(IPage<Tbpxb02> page, Req req);

	
	// 根据培训班ID获取培训信息
    List<Tbpxb02> findListByTrainingId(String id);


	List<Map<String, String>> findOptionByPxb0202(String pxb0202);
	
}
