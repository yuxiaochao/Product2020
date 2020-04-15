package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTNews;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTNewsService extends IService<HrswTNews> {

	/**
	 * 门户首页 轮播图图片
	 * @param news007 新闻类型
	 * @return
	 */
	List selectSlidePictureList(int news007) throws Exception;

	/**
	 * 门户首页信息
	 * @param user001 用户ID
	 * @return
	 */
	Map selectPortalInfoList(String user001) throws Exception;

	
}
