package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTGrouppool;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-01-10
 */
public interface IHrswTGrouppoolService extends IService<HrswTGrouppool> {

    Set<String> findGroupPool(String groupId);

    Map<String, Set<String>> findGroupPoolAll();
}
