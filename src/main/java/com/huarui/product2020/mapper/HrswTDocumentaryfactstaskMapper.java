package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTDocumentaryfactsreport;
import com.huarui.product2020.entity.HrswTDocumentaryfactstask;

import java.util.List;
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
public interface HrswTDocumentaryfactstaskMapper extends BaseMapper<HrswTDocumentaryfactstask> {
	
	/**
	 * 查询  纪实任务名称
	 * @return
	 * @throws Exception
	 */
	public 	HrswTDocumentaryfactstask selectFactsTask() throws Exception;
	
	/**
	 * 判断该用户 是否 提交过
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public HrswTDocumentaryfactsreport selectFactsReport(Map map) throws Exception;
	
	/**
	 * 查询 已经完成 且 提交了评价了的任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectTaskSucc(Map map) throws Exception;
	
	/**
	 * 查询 纪实 历史
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectTaskHistory(Map map) throws Exception;
	
	/**
	 *	 查询全部系统生成队列
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List initSystemQueue(Map map) throws Exception;
	
	/**
	 *	 查询未上报的纪实
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List initDocumentaryHistory(Map map) throws Exception;
	
	/**
	 *	统计未上报的实绩纪实，问题纪实格二级分类的条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List findByDofa010Count(Map map) throws Exception;
	
	/**
	 *	 查询未上报的纪实
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List initDocumentaryHistory01(Map map) throws Exception;
	
	/**
	 *	统计未上报的实绩纪实，问题纪实格二级分类的条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List findByDofa010Count01(Map map) throws Exception;
	
	/**
	 *	 查询在当前任务下的纪实
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectDocumentaryBydofa001(Map map) throws Exception;
	
	/**
	 *	查询在当前时间内的纪实任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectDocumentaryFactsTask(Map map) throws Exception;
	
	/**
	 *	查询我的全部提交过的纪实任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectMyFactsTask(Map map) throws Exception;
	
	/**
	 *	 查询未上报的纪实
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List initDocumentaryHistory02(Map map) throws Exception;
	
	/**
	 *	统计未上报的实绩纪实，问题纪实格二级分类的条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List findByDofa010Count02(Map map) throws Exception;
	

}