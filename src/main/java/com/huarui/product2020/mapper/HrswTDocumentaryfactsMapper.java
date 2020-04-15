package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTDocumentaryfacts;
import com.huarui.product2020.entity.HrswTDocumentaryfactsreport;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTDocumentaryfactsMapper extends BaseMapper<HrswTDocumentaryfacts> {
	
	
	/**
	 * 添加 我的纪实 1.履职纪实(系统生成) 2.实际纪实 3.问题纪实
	 * @return
	 * @throws Exception
	 */
	public boolean insertDocumentaryFacts(HrswTDocumentaryfacts docfacInfo)  throws Exception;
	
	/**
	 * 添加 我的纪实 1.履职纪实 (手工)2.实际纪实 3.问题纪实
	 * @return
	 * @throws Exception
	 */
	public boolean insertDocumentaryFactsManual(HrswTDocumentaryfacts docfacInfo)  throws Exception;
	
	/**
	 * 纪实上报
	 * @param factsReport
	 * @return
	 * @throws Exception
	 */
	public boolean insertFactsReport(HrswTDocumentaryfactsreport factsReport)throws Exception;
	
	/**
	 * 确认(添加实际纪实)
	 * @param factsReport
	 * @return
	 * @throws Exception
	 */
	public boolean insertDocumentary(HrswTDocumentaryfacts factsReport)throws Exception;
	
	/**
	 * 删除 纪实
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public  boolean deleteFacts(Map map) throws Exception;
	

}