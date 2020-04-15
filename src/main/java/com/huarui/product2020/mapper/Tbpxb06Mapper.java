package com.huarui.product2020.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbpxb06;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbpxb06Mapper extends BaseMapper<Tbpxb06> {

    List findToExcel(Map map);

	List<Tbpxb06> findStudentByPage(String id);

	List<HashMap> findNoAllocatedStudents(String pxb0101);
	/**
	 * 根据培训班id统计各种签到次数
	 * @param pagination
	 * @param req
	 * @return
	 */
	List<Map<String,String>> findCountByPxb0602(Pagination pagination,Req req);
	/**
	 * 根据培训班id、学员id统计签到类型
	 * @param pagination
	 * @param req
	 * @return
	 */
	List<Map<String,String>> findTypeByPxb0602(Pagination pagination,Req req);

    List<Tbpxb06> findTraineeList(Page<Tbpxb06> page, Map<String, Object> paramMap);
}