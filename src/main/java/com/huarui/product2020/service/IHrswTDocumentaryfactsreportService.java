package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPageByMap;
import com.huarui.product2020.entity.HrswTDocumentaryfactsreport;
import com.huarui.product2020.entity.HrswTUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface IHrswTDocumentaryfactsreportService extends IService<HrswTDocumentaryfactsreport> {
	
	
	/**
	 * 确认身份
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public HrswTUser selectidentity(Map map) throws Exception;
	
	
	/**
	 * 待我确认-纪实上报列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectFactsReport(Map map) throws Exception;
	
	/**
	 * 查看 纪实详情 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectFactsReportdetails(Map map) throws Exception;
	
	/**
	 * 确认纪实
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean updateFactsReport(Map map) throws Exception;
	
	public Integer selectNoReaderFactsReport(Map map)throws Exception;
	
	public IPageByMap queryFactsReportHistory(IPageByMap page, Map map)throws Exception;
}
