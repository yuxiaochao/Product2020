package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTJobrightsassigchild;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
public interface IHrswTJobrightsassigchildService extends IService<HrswTJobrightsassigchild> {
	
	/**
	 *	查询本科室负责人
	 * @return
	 * @throws Exception
	 */
	public List selectPrincipal(Map map) throws Exception;
	
	/**
	 *	查询主管领导
	 * @return
	 * @throws Exception
	 */
	public List selectSupervisor(Map map) throws Exception;
	
	/**
	 *	查询机构类型
	 * @return
	 * @throws Exception
	 */
	public Map selectOrganType(Map map) throws Exception;
	
}
