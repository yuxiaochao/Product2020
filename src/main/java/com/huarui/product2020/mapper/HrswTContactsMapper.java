package com.huarui.product2020.mapper;

import java.util.List;

import com.huarui.product2020.entity.HrswTApplyfor;
import com.huarui.product2020.entity.HrswTContacts;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2017-09-05
 */
public interface HrswTContactsMapper extends BaseMapper<HrswTContacts> {

	/**
	 * 获取好友列表信息
	 * @param contacts
	 * @return
	 */
	public List<HrswTContacts> findList(HrswTContacts contacts);
	
	/**
	 * 添加好友
	 */
	public void addContacts(HrswTApplyfor apply);
}