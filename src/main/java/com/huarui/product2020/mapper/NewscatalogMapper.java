package com.huarui.product2020.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.HrswTNewscatalog;

/**
 * <p>
  * 新闻栏目 Mapper 接口
 * </p>
 *
 * @author mayongqiang
 * @since 2020-03-09
 */
public interface NewscatalogMapper extends BaseMapper<HrswTNewscatalog> {

	/**
	 * 新闻分类一级列表
	 * @param page
	 * @param paramMap
	 * @return
	 */
    public List<HrswTNewscatalog> findList();
    
    /**
     * 新闻分类二级列表
     * @param page
     * @param paramMap
     * @return
     */
    public List<HrswTNewscatalog> findSecondList(String keyword);


}