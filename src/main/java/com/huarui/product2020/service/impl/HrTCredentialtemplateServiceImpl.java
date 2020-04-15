package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.HrTCredentialtemplate;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.mapper.HrTCredentialtemplateMapper;
import com.huarui.product2020.service.IHrTCredentialtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-12
 */
@Service
public class HrTCredentialtemplateServiceImpl extends ServiceImpl<HrTCredentialtemplateMapper, HrTCredentialtemplate> implements IHrTCredentialtemplateService {
	@Autowired
	HrTCredentialtemplateMapper hrTCredentialtemplateMapper;
	/**
	 * 分页查询
	 */
	@Override
	public IPage findByPage(Req req) {
		int start = req.getCurrentPage(); // 分页参数 第几页
		int limit = req.getPageSize(); // 分页参数 每页条数
		IPage page = new IPage(start, limit){};
		List records=hrTCredentialtemplateMapper.findByPage(page,req);
		page.setRecords(records);
		return page;
	}
	@Override
	public ResultEntity submit(Req req) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		String crte001 = req.getString("crte001");
		HrTCredentialtemplate entity = req.getEntity(HrTCredentialtemplate.class);
		entity.setCrte042(new Date());
		String uuid = ThreadUtils.getRTex().getUUID();
		int result=0;
		if(ThreadUtils.getRTex().isNotEmpty(crte001)) {
			result=hrTCredentialtemplateMapper.updateById(entity);
			resultEntity.setData(crte001);
		}else {
			entity.setCrte001(uuid);
			entity.setCrte043(req.getUserId());
			result=hrTCredentialtemplateMapper.insert(entity);
			resultEntity.setData(uuid);
		}
		if(result>0) {
			resultEntity.setCode(ResultEntity.RIGHT_CODE);
		}else {
			resultEntity.setErrorMsg("操作失败");
		}
		return resultEntity;
	}
	@Override
	public List certificateTemplateTree(Req req) {
		EntityWrapper<HrTCredentialtemplate> wrapper = new EntityWrapper<HrTCredentialtemplate>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("id", "-1");
		hashMap.put("name", "证书模板");
		hashMap.put("title", "证书模板");
		hashMap.put("isParent", true);
		hashMap.put("open", "true");
		List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
		list.add(hashMap);
		List<Map<String, Object>> list02 = hrTCredentialtemplateMapper.selectMaps(wrapper);
		for (Map<String, Object> map : list02) {
			map.put("id", map.get("CRTE001"));
			map.put("pid", "-1");
			map.put("name", map.get("CRTE002"));
			map.put("title", map.get("CRTE002"));
			map.put("isParent", false);
			map.put("open", "true");
		}
		list.addAll(list02);
		return list;
	}
	
	
}
