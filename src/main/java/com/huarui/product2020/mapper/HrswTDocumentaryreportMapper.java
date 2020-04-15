package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTDocumentaryreport;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
public interface HrswTDocumentaryreportMapper extends BaseMapper<HrswTDocumentaryreport> {

	/**
	 *	查询上报流水单号
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> selectReportSequence() throws Exception;
	
	/**
	 *	纪实记录
	 * @return
	 * @throws Exception
	 */
	public List selectReviewRecordList(Map map) throws Exception;
	
	/**
	 *	查询初审数据
	 * @return
	 * @throws Exception
	 */
	public List selectFirstrial(Map map) throws Exception;
	
	/**
	 *	查询复审数据
	 * @return
	 * @throws Exception
	 */
	public List selectReview(Map map) throws Exception;
	
	/**
	 *	查询我的某个任务的审核记录
	 * @return
	 * @throws Exception
	 */
	public List selectReviewByDore014(Map map) throws Exception;
	
	/**
	 *	查询初审数据
	 * @return
	 * @throws Exception
	 */
	public List selectFirstrialList(Map map) throws Exception;
	
	/**
	 *	查询复审数据
	 * @return
	 * @throws Exception
	 */
	public List selectReviewList(Map map) throws Exception;
}