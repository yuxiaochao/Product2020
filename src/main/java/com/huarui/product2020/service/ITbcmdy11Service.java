package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbcmdy11;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caifl
 * @since 2020-04-03
 */
public interface ITbcmdy11Service extends IService<Tbcmdy11> {

    List<Tbcmdy11> findRelatedCourses(Map parameterMap);
	
}
