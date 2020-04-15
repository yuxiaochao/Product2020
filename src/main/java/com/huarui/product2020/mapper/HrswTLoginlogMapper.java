package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTLoginlog;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface HrswTLoginlogMapper extends BaseMapper<HrswTLoginlog> {

	List queryLoginLogByUserID(String userID) throws Exception;
}