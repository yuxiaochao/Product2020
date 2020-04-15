package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Dcwj04;
import com.huarui.product2020.mapper.Dcwj04Mapper;
import com.huarui.product2020.service.IDcwj04Service;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 问卷试题表 服务实现类
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
@Service
public class Dcwj04ServiceImpl extends ServiceImpl<Dcwj04Mapper, Dcwj04> implements IDcwj04Service {

	/**
	 * 根据问卷id获取问卷试题
	 */
	public List<Dcwj04> queryTopicById(String dcwj0201){
		return baseMapper.queryTopicById(dcwj0201);
	}
}
