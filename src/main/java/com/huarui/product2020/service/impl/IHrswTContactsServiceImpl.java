package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTApplyfor;
import com.huarui.product2020.entity.HrswTContacts;
import com.huarui.product2020.mapper.HrswTContactsMapper;
import com.huarui.product2020.service.IHrswTContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHrswTContactsServiceImpl extends ServiceImpl<HrswTContactsMapper,HrswTContacts > implements IHrswTContactsService{
	
	@Autowired
	HrswTContactsMapper contactsMapper;
	public List<HrswTContacts> findList(HrswTContacts contacts){
		return contactsMapper.findList(contacts);
	}
	
	/**
	 * 添加好友
	 */
	public void addContacts(HrswTApplyfor apply){
		contactsMapper.addContacts(apply);
	}
}
