package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTNewscatalog;

import java.util.List;

/**
 * <p>
 * 新闻栏目 服务类
 * </p>
 */
public interface INewscatalogService extends IService<HrswTNewscatalog> {

	/**
	 * 新闻分类一级列表
	 * @return
	 */
    public List<HrswTNewscatalog> findList();
    
    /**
     * 新闻分类二级列表
     * @return
     */
    public List<HrswTNewscatalog> findSecondList(String keyword);

	
}
