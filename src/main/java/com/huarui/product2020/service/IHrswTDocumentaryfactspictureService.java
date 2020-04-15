package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTDocumentaryfactspicture;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangyalong
 * @since 2018-12-19
 */
public interface IHrswTDocumentaryfactspictureService extends IService<HrswTDocumentaryfactspicture> {
	
	/**
	 * 修改图片-删除图片
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean deletePictrue(Map map) throws Exception;
}
