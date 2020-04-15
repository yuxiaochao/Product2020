package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.product2020.entity.HrswTNews;

/**
 * <p>
 * 新闻 Mapper 接口
 * </p>
 */
public interface NewsMapper extends BaseMapper<HrswTNews> {

	/**
	 * 栏目所属新闻列表
	 * @Author mayongqiang
	 * @Date 2020年3月10日
	 */
    public List<HrswTNews> findNewsList(Pagination page, Map<String, Object> paramMap) throws Exception;

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
    public Integer findNewsSumByCatalog(@Param(value="keyword") String keyword) throws Exception;
}