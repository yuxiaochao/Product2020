package com.huarui.common.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.utils.ApplicationContextUtil;
import com.huarui.product2020.entity.HrswTSysconfig;
import com.huarui.product2020.service.IHrswTSysconfigService;

import java.util.ArrayList;
import java.util.List;


/**
 * 系统配置工具类
 *
 */
public class SystemConfiguration {

	private static IHrswTSysconfigService sysconfigService;
	private static List<HrswTSysconfig> sysconfigList = null;

	/**
	 * 根据key获取一个配置
	 * 
	 * @param key
	 *            配置的key
	 * @return
	 */

	public synchronized static HrswTSysconfig getConfig(String key) {
		HrswTSysconfig configEntity = null;
		if (null == sysconfigList || sysconfigList.size() <= 0) {
			initConfiguration();
		}
		for (HrswTSysconfig config : sysconfigList) {
			if (key.equalsIgnoreCase(config.getSysc005())) {
				configEntity = config;
				break;
			}
		}
		return configEntity;
	}
	
	/**
	 * 根据group获取一组配置
	 * 
	 * @param group
	 *            配置的分组
	 * @return
	 */
	public synchronized static List<HrswTSysconfig> getConfigByGroup(String group) {
		List<HrswTSysconfig> configEntity = new ArrayList<HrswTSysconfig>();
		if (null == sysconfigList || sysconfigList.size() <= 0) {
			initConfiguration();
		}
		for (HrswTSysconfig config : sysconfigList) {
			if (group.equalsIgnoreCase(config.getSysc011())) {
				configEntity.add(config);
				continue;
			}
		}
		return configEntity;
	}

	/**
	 * 获取一个配置项的值
	 * 
	 * @param key
	 *            配置项的key
	 * @return
	 */
	public synchronized static String getProperty(String key) {
		HrswTSysconfig configEntity = getConfig(key);
		String property = null;
		if (null != configEntity) {
			property = configEntity.getSysc007();
		}
		return property;

	}

	/**
	 * 初始化系统配置，用于重新加载配置
	 */
	public synchronized static void initConfiguration() {
		HrswTSysconfig t = new HrswTSysconfig();
		EntityWrapper sysWr = new EntityWrapper();
		sysWr.setEntity(t);
		sysWr.where("SYSC012 = {0}", 1);
		sysconfigList = getConfigService().selectList(sysWr);
	}

	public synchronized static IHrswTSysconfigService getConfigService() {
		if (null == sysconfigService) {
			sysconfigService = (IHrswTSysconfigService) ApplicationContextUtil.getBean("hrswTSysconfigServiceImpl");
		}
		return sysconfigService;
	}

}
