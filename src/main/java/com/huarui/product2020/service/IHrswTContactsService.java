package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTApplyfor;
import com.huarui.product2020.entity.HrswTContacts;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2017-09-05
 */
public interface IHrswTContactsService extends IService<HrswTContacts> {
	
	public List<HrswTContacts> findList(HrswTContacts contacts);
	
	/**
	 * 添加好友
	 */
	public void addContacts(HrswTApplyfor apply);
}
