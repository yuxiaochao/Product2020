package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTDocumentaryfactspicture;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhangyalong
 * @since 2018-12-19
 */
public interface HrswTDocumentaryfactspictureMapper extends BaseMapper<HrswTDocumentaryfactspicture> {

	/**
	 * 修改图片-删除图片
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean deletePictrue(Map map) throws Exception;
}