package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbwdkc02;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public interface ITbwdkc02Service extends IService<Tbwdkc02> {

    /**
     * 查询
     * 我的课程——课程list
     */
    public List<Tbwdkc02> findbyCourseList(Tbwdkc02 tbwdkc02);
}
