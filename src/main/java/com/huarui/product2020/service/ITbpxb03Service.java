package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbpxb03;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbpxb03Service extends IService<Tbpxb03> {

    List<Tbpxb03> findClassPersonnel(Map paramMap);
	
}
