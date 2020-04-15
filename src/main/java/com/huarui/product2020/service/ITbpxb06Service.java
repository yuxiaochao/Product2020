package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbpxb06;

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
public interface ITbpxb06Service extends IService<Tbpxb06> {

    List findToExcel(Map map);

	List<Tbpxb06> findStudentByPage(String id);
	
	/**
	 * 根据培训班id统计各种签到次数
	 * @param req
	 * @return
	 */
	IPage findCountByPxb0602(Req req);
	/**
	 * 根据培训班id、学员id统计签到类型
	 * @param req
	 * @return
	 */
	IPage findTypeByPxb0602(Req req);

	
	
    Page<Tbpxb06> findTraineeList(Page<Tbpxb06> page, Map<String, Object> paramMap);
}
