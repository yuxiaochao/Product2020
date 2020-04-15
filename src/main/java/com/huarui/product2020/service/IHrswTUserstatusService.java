package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTUserstatus;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface IHrswTUserstatusService extends IService<HrswTUserstatus> {
	
	/**
     * 手动添加用户状态
     * @param userInfo
     * @return
     * @throws Exception
     */
	public boolean insertInfo(HrswTUserstatus userInfo) throws Exception;
}
