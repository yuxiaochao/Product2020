package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Dcwj04;

import java.util.List;

/**
 * <p>
 * 问卷试题表 服务类
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public interface IDcwj04Service extends IService<Dcwj04> {
	
	/**
	 * 根据问卷id获取问卷试题
	 */
	public List<Dcwj04> queryTopicById(String dcwj0201);
	
}
