package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTNews;

import java.util.Map;

/**
 * <p>
 * 新闻栏目 服务类
 * </p>
 */
public interface INewsService extends IService<HrswTNews> {

	/**
	 * 栏目所属新闻列表
	 * @return
	 */
    public IPage<HrswTNews> findNewsList(IPage<HrswTNews> page, Map<String, Object> paramMap)  throws Exception;
	
    /**
	 * 查询新闻内容
	 * @Author mayongqiang
	 * @Date 2020年3月10日
	 */
    public HrswTNews findById(String news001) throws Exception;
    
    /**
	 * 查询某栏目下的新闻总条数
	 * @Author mayongqiang
	 * @Date 2020年3月11日
	 */
    public Integer findNewsSumByCatalog(String keyword) throws Exception;
}
