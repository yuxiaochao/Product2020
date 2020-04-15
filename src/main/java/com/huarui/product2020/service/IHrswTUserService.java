package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTUserService extends IService<HrswTUser> {

	
	/**
	 * 根据账户 核实身份
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public HrswTUser checkAccount(Map map) throws Exception;
	
	/**
	 * 找回密码 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean retrievePassword(Map map) throws Exception;
	
	/**
	 * 查询用户信息
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	Map selectMapForUserInfo(String username, String password) throws Exception;
	
	/**
	 * 查询用户信息
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	Map selectUserInfo(Map map) throws Exception;
	
	/**
	 * 修改密码
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	boolean updatePwd(Map map) throws Exception;

	/**
	 * 我的 用户信息
	 * @param user001 用户ID
	 * @return
	 */
	Map selectUserInfoById(String user001) throws Exception;

	/**
	 * 我的 用户二维码
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	String selectUserQRCodeById(String user001) throws Exception;
	
	List selectuserInfoMultipleById(Map map) throws Exception;
	
	/**
	 * 个人信息
	 * @return
	 * @throws Exception
	 */
	public List userInfo(Map map)throws Exception;
	
	/**
	 * 查询用户信息列表
	 * @param page
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public IPage queryUserInfoList(IPage page, Map<String, Object> paramMap) throws Exception;

	/**
	 * 导出Excel
	 *
	 * @return
	 */
	public List findToExcel(Map map);

	
	/**
	 * 根据条件查询工作人员
	 * @param page
	 * @param paramMap
	 * @return
	 */
    public Page<HrswTUser> findWorkPersonnel(IPage<HrswTUser> page, Map<String, Object> paramMap);


    //根据手机号（账号查询用户信息）
	public Map<String, Object> selectMapForUserInfo1(String username);


	public boolean updateUserInfo(String user001, String users, String modelName);

	void uploadUserPic(Map map);

	//上传头像
	int uploadPic(Map map);


}
