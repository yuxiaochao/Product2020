package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrTCredentialtemplate;
import com.huarui.product2020.entity.HrswTUser;
import com.huarui.product2020.entity.ResultEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-12
 */
public interface IHrTCredentialtemplateService extends IService<HrTCredentialtemplate> {
	/**
	 * 分页查询
	 * @param req
	 * @return
	 */
	IPage<HrswTUser> findByPage(Req req);
	/**
	 * 插入或更新
	 * @param req
	 * @return
	 * @throws Exception
	 */
	ResultEntity submit(Req req) throws Exception;
	List certificateTemplateTree(Req req);
	
}
