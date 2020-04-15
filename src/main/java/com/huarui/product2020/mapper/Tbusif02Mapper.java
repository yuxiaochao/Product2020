package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbusif02;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-02-16
 */
public interface Tbusif02Mapper extends BaseMapper<Tbusif02> {

	Map<String, Object> getMailingAddress(String webUserId);

}