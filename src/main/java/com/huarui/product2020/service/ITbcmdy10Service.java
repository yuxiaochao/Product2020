package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbcmdy10;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caifl
 * @since 2020-04-07
 */
public interface ITbcmdy10Service extends IService<Tbcmdy10> {

    List<Tbcmdy10> findCourseAuditions(Map parameterMap);

    List<Tbcmdy10> findCourseAuditionsClassify(Map parameterMap);
	
}
