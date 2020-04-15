package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTPassword;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-08-26
 */
public interface IHrswTPasswordService extends IService<HrswTPassword> {
	
	public boolean insertOrUpdate( HrswTPassword passwordEntity);
	
}
