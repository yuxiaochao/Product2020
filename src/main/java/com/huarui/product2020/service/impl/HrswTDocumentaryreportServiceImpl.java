package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTDocumentaryreport;
import com.huarui.product2020.mapper.HrswTDocumentaryreportMapper;
import com.huarui.product2020.service.IHrswTDocumentaryreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
@Service
public class HrswTDocumentaryreportServiceImpl extends ServiceImpl<HrswTDocumentaryreportMapper, HrswTDocumentaryreport> implements IHrswTDocumentaryreportService {

	@Autowired
	private HrswTDocumentaryreportMapper mapper;
	
	/**
	 *	查询上报流水单号
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, String> selectReportSequence() throws Exception {
		return mapper.selectReportSequence();
	}

	@Override
	public List selectReviewRecordList(Map map) throws Exception {
		return mapper.selectReviewRecordList(map);
	}

	@Override
	public List selectFirstrial(Map map) throws Exception {
		return mapper.selectFirstrial(map);
	}

	@Override
	public List selectReview(Map map) throws Exception {
		return mapper.selectReview(map);
	}

	@Override
	public List selectReviewByDore014(Map map) throws Exception {
		return mapper.selectReviewByDore014(map);
	}

	@Override
	public List selectFirstrialList(Map map) throws Exception {
		return mapper.selectFirstrialList(map);
	}

	@Override
	public List selectReviewList(Map map) throws Exception {
		return mapper.selectReviewList(map);
	}
	
}
