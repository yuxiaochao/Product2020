package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbpxb02;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbpxb02Mapper extends BaseMapper<Tbpxb02> {

	List<Tbpxb02> findByPage(IPage<Tbpxb02> page, Req req);

    List<Tbpxb02> findListByTrainingId(String id);

	List<Map<String, String>> findOptionByPxb0202(String pxb0202);
	/**
	 * 案例分析弹窗课程
	 * @param req
	 * @return
	 */
	List<Map<String,String>> findAllCaseCourse(Req req,IPage page);
}