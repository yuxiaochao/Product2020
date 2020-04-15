package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbwdkc02;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public interface Tbwdkc02Mapper extends BaseMapper<Tbwdkc02> {
    /**
     * 查询
     * 我的课程——课程list
     */
    public List<Tbwdkc02> findbyCourseList(Tbwdkc02 tbwdkc02);
}