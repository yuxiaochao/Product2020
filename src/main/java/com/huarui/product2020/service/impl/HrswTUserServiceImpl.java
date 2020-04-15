package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTUser;
import com.huarui.product2020.mapper.HrswTUserMapper;
import com.huarui.product2020.service.IHrswTUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class HrswTUserServiceImpl extends ServiceImpl<HrswTUserMapper, HrswTUser> implements IHrswTUserService {

	@Autowired
	private HrswTUserMapper userMapper;

	public Map selectMapForUserInfo(String username, String password) throws Exception {
		return baseMapper.selectMapForUserInfo(username,password);
	}

	public Map selectUserInfoById(String user001) throws Exception {
		return baseMapper.selectUserInfoById(user001);
	}

	public String selectUserQRCodeById(String user001) throws Exception {
		return baseMapper.selectUserQRCodeById(user001);
	}

	@Override
	public List selectuserInfoMultipleById(Map map) throws Exception {
		return baseMapper.selectuserInfoMultipleById(map);
	}

	@Override
	public Map selectUserInfo(Map map) throws Exception {
		return baseMapper.selectUserInfo(map);
	}

	@Override
	public boolean updatePwd(Map map) throws Exception {
		return baseMapper.updatePwd(map);
	}

	@Override
	public List userInfo(Map map) throws Exception {
		return baseMapper.userInfo(map);
	}

	@Override
	public HrswTUser checkAccount(Map map) throws Exception {
		return baseMapper.checkAccount(map);
	}

	@Override
	public boolean retrievePassword(Map map) throws Exception {
		return baseMapper.retrievePassword(map);
	}
	
	public IPage queryUserInfoList(IPage page, Map<String, Object> paramMap) throws Exception {
		page.setRecords(baseMapper.queryUserInfoList(page,paramMap));
		return page;
	}

	@Override
	public List findToExcel(Map map) {
		return baseMapper.findToExcel(map);
	}

    @Override
    public Page<HrswTUser> findWorkPersonnel(IPage<HrswTUser> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findWorkPersonnel(page,paramMap));
        return page;
    }

	@Override
	public Map<String, Object> selectMapForUserInfo1(String username) {
		return baseMapper.selectMapForUserInfo1(username);
	}

	@Override
	public boolean updateUserInfo(String user001, String users, String modelName) {
		return baseMapper.updateUserInfo(user001,  users, modelName);
	}

	//上传头像
	@Override
	public int uploadPic(Map map) {
		return userMapper.uploadPic(map);
	}

	@Override
	public void uploadUserPic(Map map) {
		userMapper.uploadUserPic(map);
	}

}
