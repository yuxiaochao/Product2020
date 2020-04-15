package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTMessagereader;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTMessagereaderService extends IService<HrswTMessagereader> {
	
	/**
	 * 写入阅读信息表
	 * @return
	 * @throws Exception
	 */
	public boolean insertMessagereader(HrswTMessagereader info) throws Exception;
}
