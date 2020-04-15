package com.huarui.product2020.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface HrswTUserMapper extends BaseMapper<HrswTUser> {

	
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
	 * @return
	 */
	Map selectUserInfo(Map map) throws Exception;
	
	/**
	 * 修改密码
	 * @return
	 */
	boolean updatePwd(Map map) throws Exception;

	/**
	 * 我的 用户信息
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
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
	public List queryUserInfoList(IPage page, Map<String, Object> paramMap) throws Exception;

	/**
	 * 导出Excel
	 *
	 * @return
	 */
	public List<HrswTUser> findToExcel(Map map);


    public List<HrswTUser> findWorkPersonnel(IPage<HrswTUser> page, Map<String, Object> paramMap);


	public Map<String, Object> selectMapForUserInfo1(String username);

	boolean updateUserInfo(@Param( "user001") String user001, @Param( "users") String users, @Param( "modelName")String modelName);

	int uploadPic(Map map);

	void uploadUserPic(Map map);
}