package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.HrswTOrgan;
import com.huarui.product2020.mapper.HrswTOrganMapper;
import com.huarui.product2020.service.IHrswTOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTOrganServiceImpl extends ServiceImpl<HrswTOrganMapper, HrswTOrgan> implements IHrswTOrganService {

	@Autowired
	private HrswTOrganMapper organMapper;
	
	public int findUserOrgStatus(String organID) throws Exception {
		return organMapper.findUserOrgStatus(organID);
	}
	
	/**
	 * 获取异步机构树 JSON数据
	 * 
	 * @param id
	 * @return
	 */
//	@RedisCached(cacheKey = "syncOrganTree", SerializerMode = SerializerMode.JSON)
	public List syncOrganTree(String id, Map<String, Object> map, Req req) {
		String keyWord = req.getString("keyWord");

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		if (ThreadUtils.getRTex().isEmpty(id) || "0".equals(id)) {
			
			Map<String, Object> organMap = new HashMap<String, Object>();
			organMap.put("id", "-1");
			organMap.put("name", "组织机构");
			organMap.put("title", "组织机构");
			organMap.put("organLevel", "0");
			organMap.put("organLevelname", "");
			organMap.put("pid", "-9999");
			organMap.put("isParent", true);
			organMap.put("open", "true");
			
			list.add(organMap);
			
			if(keyWord == null || keyWord.equals("")) {
				return list;
			}
		}
		String organTreeType = ThreadUtils.getRTex().toString(map.get("organTreeType"));
		String level = ThreadUtils.getRTex().toString(map.get("level"));
		map.put("orga002", id);
		map.put("userId", req.getUserId());
		map.put("organId", req.getUserManagerOrganId());
		map.put("userName", req.getUserName());
		
		Integer source = req.getCompanySource();//获得该角色来源 1,'运营单位',2,'认证单位',3,'报名单位'
		
		List organlist = new ArrayList();
		if(organTreeType.equals("1")) {//认证机构
			if(source == 1) {//运管平台查看所有的认证机构
				map.put("isRemovePurview", 1);
			}else if(source == 2){//认证机构管理员查看当前所管理的机构
				if(id.equals("-1")) {//如果点击的是中电联
					map.put("isRemovePurview", 0);
				}else {
					map.put("isRemovePurview", 1);
				}
			}else if(source == 3){//报名机构管理员查看认证机构
				map.put("isRemovePurview", 1);
			}
			organlist = organMapper.authenticaOrganTree(map);
		}else if(organTreeType.equals("2")) {//报名单位
			if(source == 1) {
				map.put("isRemovePurview", 1);
			}else if(source == 2){//认证机构管理员查看报名单位
				map.put("isRemovePurview", 1);
			}else{
				if(id.equals("-1")) {//如果点击的是中电联
					map.put("isRemovePurview", 0);
				}else {
					map.put("isRemovePurview", 1);
				}
			}
			organlist = organMapper.registrationOrganTree(map);
		}else if(organTreeType.equals("3")) {//运营单位
			organlist = organMapper.operationOrganTree(map);
		}else if(organTreeType==null || ("").equals(organTreeType) || ("-1").equals(organTreeType)) {
			//organlist = switchingMapper("findOrganTree", new Class[] {Map.class}, map);
			
			if("-1".equals(id)) {
				map.put("enroll", false);
				boolean enroll = false;
				organlist = organMapper.findOrganTree(map);
				List copyorganlist = new ArrayList();
				copyorganlist = organMapper.findOrganTree(map);
				for (Object object : copyorganlist) {
					Map<String, Object> organMap = (Map<String, Object>)object;
					Object obj = organMap.get("ORGA020");
					if(obj != null && "2".equals(obj.toString())) {
					   // 是否存在报名机构
					    enroll = true;
                        organlist.remove(object);
					}
				}
				if(enroll) {
					Map<String, Object> enrollMap = new HashMap<String, Object>();
					enrollMap.put("id", "-2");
					enrollMap.put("name", "报名机构");
					enrollMap.put("title", "00000000-报名机构");
					enrollMap.put("organLevel", "1");
					enrollMap.put("organLevelname", "报名机构");
					enrollMap.put("pid", id);
					enrollMap.put("isParent", true);
					enrollMap.put("open", "true");
					list.add(enrollMap);
				}
			} else if("-2".equals(id)) {
				map.put("enroll", false);
				map.put("orga002", "-1");
				organlist = organMapper.registrationOrganTree(map);
				for(Object ho : organlist){
					HrswTOrgan ho2 = (HrswTOrgan)ho;
					ho2.setOrga002("-2");
				}
			} else {
				map.put("enroll", false);
				organlist = organMapper.findOrganTree(map);
			}
			
		}
		for (Object obj : organlist) {
			Map<String, Object> organEntity = new HashMap<String, Object>();
			if(obj instanceof Map) {
				organEntity = (Map<String, Object>)obj;
			}
			else if(obj instanceof Model) {
				organEntity = ThreadUtils.getRTex().EntityToMapKeytoUpper(obj);
			}
			Map<String, Object> organMap = new HashMap<String, Object>();
			organMap.put("id", organEntity.get("ORGA001"));
			organMap.put("name", organEntity.get("ORGA006"));
			organMap.put("title", ThreadUtils.getRTex().toString((organEntity.get("ORGA003")) + "-" + ThreadUtils.getRTex().toString(organEntity.get("ORGA005"))));
			organMap.put("organLevel", organEntity.get("ORGA010"));
			organMap.put("organLevelname", organEntity.get("ORGA012"));
			organMap.put("pid", organEntity.get("ORGA002"));

			String child = ThreadUtils.getRTex().toString(organEntity.get("CHILDCOUNT"), "0");
			if((organEntity.get("ORGA010").toString()).equals(level)) {
				organMap.put("isParent", false);
				organMap.put("open", "false");
			}else {
				if ("0".equals(child)) {
					organMap.put("isParent", false);
					organMap.put("open", "false");
				} else {
					organMap.put("isParent", true);
					organMap.put("open", "true");
				}
			}

			list.add(organMap);
		}
		return list;
	}

	@Override
	public HrswTOrgan findById(String userOrganId) {
		return organMapper.findById(userOrganId);
	}
	
}
