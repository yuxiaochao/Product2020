package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTDocumentaryfacts;
import com.huarui.product2020.entity.HrswTDocumentaryfactsreport;
import com.huarui.product2020.mapper.HrswTDocumentaryfactsMapper;
import com.huarui.product2020.service.IHrswTDocumentaryfactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class HrswTDocumentaryfactsServiceImpl extends ServiceImpl<HrswTDocumentaryfactsMapper, HrswTDocumentaryfacts> implements IHrswTDocumentaryfactsService {

	@Autowired
	private HrswTDocumentaryfactsMapper factsMapper;
	
	
	@Override
	public boolean insertDocumentaryFacts(HrswTDocumentaryfacts docfacInfo) throws Exception {
		// TODO Auto-generated method stub
		return factsMapper.insertDocumentaryFacts(docfacInfo);
	}


	@Override
	public boolean insertDocumentaryFactsManual(HrswTDocumentaryfacts docfacInfo) throws Exception {
		// TODO Auto-generated method stub
		return factsMapper.insertDocumentaryFactsManual(docfacInfo);
	}


	@Override
	public boolean insertFactsReport(HrswTDocumentaryfactsreport factsReport) throws Exception {
		// TODO Auto-generated method stub
		return factsMapper.insertFactsReport(factsReport);
	}


	@Override
	public boolean insertDocumentary(HrswTDocumentaryfacts factsReport) throws Exception {
		// TODO Auto-generated method stub
		return factsMapper.insertDocumentary(factsReport);
	}


	@Override
	public boolean deleteFacts(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factsMapper.deleteFacts(map);
	}
	
	
}
