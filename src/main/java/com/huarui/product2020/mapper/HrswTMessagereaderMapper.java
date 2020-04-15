package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTMessagereader;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface HrswTMessagereaderMapper extends BaseMapper<HrswTMessagereader> {
	
	
	/**
	 * 写入阅读信息表
	 * @return
	 * @throws Exception
	 */
	public boolean insertMessagereader(HrswTMessagereader info) throws Exception;

}