package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPageByMap;
import com.huarui.product2020.entity.HrswTDocumentaryfactsreport;
import com.huarui.product2020.entity.HrswTUser;
import com.huarui.product2020.mapper.HrswTDocumentaryfactsreportMapper;
import com.huarui.product2020.service.IHrswTDocumentaryfactsreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
@Service
public class HrswTDocumentaryfactsreportServiceImpl extends ServiceImpl<HrswTDocumentaryfactsreportMapper, HrswTDocumentaryfactsreport> implements IHrswTDocumentaryfactsreportService {

	@Autowired
	private HrswTDocumentaryfactsreportMapper factsreportMapper;
	
	@Override
	public List selectFactsReport(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factsreportMapper.selectFactsReport(map);
	}

	@Override
	public List selectFactsReportdetails(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factsreportMapper.selectFactsReportdetails(map);
	}

	@Override
	public boolean updateFactsReport(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factsreportMapper.updateFactsReport(map);
	}

	@Override
	public Integer selectNoReaderFactsReport(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factsreportMapper.selectNoReaderFactsReport(map);
	}

	@Override
	public IPageByMap queryFactsReportHistory(IPageByMap page, Map map) throws Exception {
		 List factsReportHistory = factsreportMapper.queryFactsReportHistory(page,map);
		 
		 page.setRecords(factsReportHistory);
		 
		 return page;
	}

	@Override
	public HrswTUser selectidentity(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factsreportMapper.selectidentity(map);
	}
	
}
