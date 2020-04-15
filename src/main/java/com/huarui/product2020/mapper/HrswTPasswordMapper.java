package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTPassword;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2019-08-26
 */
public interface HrswTPasswordMapper extends BaseMapper<HrswTPassword> {

	boolean insertOrUpdate(HrswTPassword passwordEntity);

}