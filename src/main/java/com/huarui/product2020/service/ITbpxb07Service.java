package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbpxb07;

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
public interface ITbpxb07Service extends IService<Tbpxb07> {

    
    List<Tbpxb07> findByClassHourRequirementList(Map paramMap);
	
}
