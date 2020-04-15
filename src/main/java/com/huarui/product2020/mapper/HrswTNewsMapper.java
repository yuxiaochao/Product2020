package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTNews;

import java.util.List;
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
public interface HrswTNewsMapper extends BaseMapper<HrswTNews> {

	/**
	 * 门户首页 轮播图图片
	 * @param news007
	 * @return
	 */
	List selectSlidePictureList(int news007) throws Exception;

	/**
	 * 门户首页信息
	 * @param user001
	 * @return
	 * @throws Exception
	 */
	Map selectPortalInfoList(String user001) throws Exception;

}