package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTDocumentaryfactsreport;
import com.huarui.product2020.entity.HrswTDocumentaryfactstask;
import com.huarui.product2020.mapper.HrswTDocumentaryfactstaskMapper;
import com.huarui.product2020.service.IHrswTDocumentaryfactstaskService;
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
public class HrswTDocumentaryfactstaskServiceImpl extends ServiceImpl<HrswTDocumentaryfactstaskMapper, HrswTDocumentaryfactstask> implements IHrswTDocumentaryfactstaskService {

	@Autowired
	private HrswTDocumentaryfactstaskMapper factstaskMapper;
	
	@Override
	public HrswTDocumentaryfactstask selectFactsTask() throws Exception {
		// TODO Auto-generated method stub
		return factstaskMapper.selectFactsTask();
	}

	@Override
	public List selectTaskSucc(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factstaskMapper.selectTaskSucc(map);
	}

	@Override
	public List selectTaskHistory(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factstaskMapper.selectTaskHistory(map);
	}

	@Override
	public boolean selectFactsReport(Map map) throws Exception {
		// TODO Auto-generated method stub
		 HrswTDocumentaryfactsreport userMap = factstaskMapper.selectFactsReport(map);
		if(userMap==null) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public List initSystemQueue(Map map) throws Exception {
		return factstaskMapper.initSystemQueue(map);
	}

	@Override
	public List initDocumentaryHistory(Map map) throws Exception {
		return factstaskMapper.initDocumentaryHistory(map);
	}

	@Override
	public List findByDofa010Count(Map map) throws Exception {
		return factstaskMapper.findByDofa010Count(map);
	}

	@Override
	public List initDocumentaryHistory01(Map map) throws Exception {
		return factstaskMapper.initDocumentaryHistory01(map);
	}

	@Override
	public List findByDofa010Count01(Map map) throws Exception {
		return factstaskMapper.findByDofa010Count01(map);
	}

	@Override
	public List selectDocumentaryBydofa001(Map map) throws Exception {
		return factstaskMapper.selectDocumentaryBydofa001(map);
	}

	@Override
	public List selectDocumentaryFactsTask(Map map) throws Exception {
		return factstaskMapper.selectDocumentaryFactsTask(map);
	}

	@Override
	public List selectMyFactsTask(Map map) throws Exception {
		return factstaskMapper.selectMyFactsTask(map);
	}

	@Override
	public List initDocumentaryHistory02(Map map) throws Exception {
		return factstaskMapper.initDocumentaryHistory02(map);
	}

	@Override
	public List findByDofa010Count02(Map map) throws Exception {
		return factstaskMapper.findByDofa010Count02(map);
	}
	
	
}
