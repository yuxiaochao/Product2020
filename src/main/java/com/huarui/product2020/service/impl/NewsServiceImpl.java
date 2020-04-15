package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTNews;
import com.huarui.product2020.mapper.NewsMapper;
import com.huarui.product2020.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 新闻栏目 服务实现类
 * </p>
 *
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, HrswTNews> implements INewsService {

    
    @Autowired
    private NewsMapper newsMapper;

	@Override
	public IPage<HrswTNews> findNewsList(IPage<HrswTNews> page, Map<String, Object> paramMap) throws Exception {
		page.setRecords(newsMapper.findNewsList(page, paramMap));
		return page;
	}

	@Override
	public HrswTNews findById(String news001) throws Exception {
		return newsMapper.findById(news001);
	}

	@Override
	public Integer findNewsSumByCatalog(String keyword) throws Exception {
 		return newsMapper.findNewsSumByCatalog(keyword);
	}

    
}
