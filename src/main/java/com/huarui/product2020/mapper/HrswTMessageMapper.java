package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTMessage;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface HrswTMessageMapper extends BaseMapper<HrswTMessage> {

	/**
	 * 门户 查询消息未读数
	 * @param user001
	 * @return
	 */
	String selectMessageNum(String user001) throws Exception;

}