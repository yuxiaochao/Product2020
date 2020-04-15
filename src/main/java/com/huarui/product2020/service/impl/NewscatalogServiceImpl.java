package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTNewscatalog;
import com.huarui.product2020.mapper.NewscatalogMapper;
import com.huarui.product2020.service.INewscatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 新闻栏目 服务实现类
 * </p>
 *
 */
@Service
public class NewscatalogServiceImpl extends ServiceImpl<NewscatalogMapper, HrswTNewscatalog> implements INewscatalogService {

    
    @Autowired
    private NewscatalogMapper newscatalogMapper;

	@Override
	public List<HrswTNewscatalog> findList() {
		return newscatalogMapper.findList();
	}

	@Override
	public List<HrswTNewscatalog> findSecondList(String keyword) {
		return newscatalogMapper.findSecondList(keyword);
	}
    
}
