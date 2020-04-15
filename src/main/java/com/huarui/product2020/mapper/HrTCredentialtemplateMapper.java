package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrTCredentialtemplate;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-12
 */
public interface HrTCredentialtemplateMapper extends BaseMapper<HrTCredentialtemplate> {
	/**
	 * 分页查询
	 * @param page
	 * @param req
	 * @return
	 */
	List findByPage(IPage page, Req req);

}