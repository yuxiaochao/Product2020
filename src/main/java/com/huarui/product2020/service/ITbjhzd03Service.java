package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbjhzd03;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjhzd03Service extends IService<Tbjhzd03> {

	List<Tbjhzd03> findByPage();
	
}
