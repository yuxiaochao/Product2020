package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Traineearrange;

import java.util.Map;

/**
 * <p>
 * 学员安排 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
public interface ITraineearrangeService extends IService<Traineearrange> {

    Integer findTodoArrangedMaleCount(Map<String, Object> paramMap);

    Integer findTodoArrangedFemaleCount(Map<String, Object> paramMap);
	
}
