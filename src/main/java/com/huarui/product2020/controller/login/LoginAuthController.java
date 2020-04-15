package com.huarui.product2020.controller.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.tuzip.sso.SSOConfig;
import com.github.tuzip.sso.SSOToken;
import com.huarui.common.DesEncryption;
import com.huarui.common.PasswordHelper;
import com.huarui.common.Req;
import com.huarui.common.config.Global;
import com.huarui.common.config.SystemConfiguration;
import com.huarui.common.utils.*;
import com.huarui.common.utils.sms.SendSmsResult;
import com.huarui.common.utils.sms.utils.SmsSmsSenderUtils;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.service.*;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * app登录
 *
 * @author DongJie
 * @since 2017年8月17日
 */
@RestController
@RequestMapping("/user")
public class LoginAuthController {

	@Autowired
	private IHrswTUserService userService;
	
	@Autowired
	private IHrswTUserpurviewService userpurviewService;
	
	@Autowired
	private IHrswTOrganService organService;
	
	@Autowired
	private IHrswTLoginlogService loginService;
	
	@Autowired
	private IHrswTSysconfigService sysConfigService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ITbgwc01Service tbgwc01Service;
	
	//密码管理
	@Autowired
	private IHrswTPasswordService hrswTPasswordService;

//	@Autowired
//	ThymeleafViewResolver thymeleafViewResolver;
	
	@RequestMapping("/login")
	public ResultEntity login(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// 返回信息
		ResultEntity result = new ResultEntity();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 获取输入参数
		String username = ObjectUtils.toString(request.getParameter("USER004"));// 用户名
		String password = ObjectUtils.toString(request.getParameter("USER016"));// 密码
		String operateSystem = ObjectUtils.toString(request.getParameter("USER026"));// 操作系统：Android ，IOS
		String iemi = ObjectUtils.toString(request.getParameter("LLOG012"));
		
		// 登录验证
		EntityWrapper<HrswTUser> userEW = new EntityWrapper<HrswTUser>();
		userEW.setEntity(new HrswTUser());
		userEW.where("USER004 = {0}", username);
		List<HrswTUser> userList = userService.selectList(userEW);
	
		if( null == userList || userList.size() == 0){                          // 用户是否存在
			result.setErrorMsg("账户或密码错误");
		}else if(userList.size() > 1){                  // 是否存在多个账号
			result.setErrorMsg("该账号在系统中存在多个，请联系管理员！");
		}else{
			HrswTUser hu = userList.get(0);
			String salt = "";
			if(hu!=null) {
				//salt = hu.getUser030();//获取用户的盐
				salt = ObjectUtils.toString(hu.getUser030(),"");
			}
			
			//password = PasswordHelper.entryptPassword(password, salt);              // 对密码进行加密
			password = Md5PwdEncoder.encode(String.valueOf(Md5PwdEncoder.encode(password)) + salt);
//			password = "loginAgain1070331325";
			Map<String, Object> userMap = userService.selectMapForUserInfo(username,password); // 查询用户信息
			if(null == userMap){
				result.setErrorMsg("账户或密码错误");
			}else {
				String organID = ObjectUtils.toString(userMap.get("USER002")) ;  // 用户机构ID
				int organState = organService.findUserOrgStatus(organID);        // 查询用户机构状态
				int user017 = NumberUtils.toInt(ObjectUtils.toString(userMap.get("USER017")));
				if(user017 == 3){                          // 用户状态
					result.setErrorMsg("用户已禁用");
				}else if(organState == 2){ 
					result.setErrorMsg("用户所在机构已被禁用");
				}else if(organState == 3) {
					result.setErrorMsg("用户所在机构已被删除");
				}else{
					// 发送APP推送消息，前一个登陆系统的用户提示退出系统
					String userID = ObjectUtils.toString(userMap.get("USER001")) ; // 用户ID
					/*List webLogList = loginService.queryLoginLogByUserID(userID);     // 查询用户登录信息
					if(null != webLogList && webLogList.size() >= 1){
						if(null != webLogList.get(0)){
							HrswTLoginlog logMap = (HrswTLoginlog) webLogList.get(0);
							String alias = ObjectUtils.toString(logMap.getLlog012()); // 设备标识码
							String cont = "{userid:'" + userID + "'}";
							if (null != alias && alias.length() >= 1 && !iemi.equals(alias)) {
								String browser = ObjectUtils.toString(logMap.getLlog006());
								if("Android".equalsIgnoreCase(browser)){
									JPushUtils.sendAndroidJpushWithAlias("offline", cont, alias);
								}else if ("IOS".equalsIgnoreCase(browser)) {
									JPushUtils.sendIOSJpushWithAlias("offline", cont, alias);
								}
							}	
						}
					}*/
					
					
					// 插入登陆日志
					HrswTLoginlog loginLog = new HrswTLoginlog();
					String sessionID = request.getSession().getId();
					String userIP = request.getRemoteAddr();
					String token = ThreadUtils.getRTex().getUUID();
					loginLog.setLlog010(1L);
					loginLog.setLlog002(sessionID);
					loginLog.setLlog003(userID);
					loginLog.setLlog004(userIP);
					loginLog.setLlog005(new Date());
					loginLog.setLlog008(operateSystem);
					loginLog.setLlog011(token);
					loginService.insert(loginLog);
					
					String user001 = ObjectUtils.toString(userMap.get("USER001"));
					String rsaToken = JwtUtils.jwtToken(token,username,user001);
					if(rsaToken.equals("")) {
						result.setErrorMsg("请求发生异常");
						return result;
					}
					map.put("token", rsaToken);
					
					//获取系统配置信息
					getSystemConfig(map,username,token);
					
					userMap.put("llog001", loginLog.getLlog001());
					
					//设置user管理员信息
					ThreadUtils.getWebUtil().setUserManagementInformation(userMap);
				
					try {
						//token、用户信息放入redis
						saveTokenUser(username,token,userMap);
					} catch (Exception e) {
						result.setErrorMsg("请求发生异常");
						return result;
					}
					
					
					//生成
					map.put("user", ThreadUtils.getRTex().formatMap(userMap));
					int queryShoppingCartCount = tbgwc01Service.queryShoppingCartCount(hu.getUser001());
					map.putIfAbsent("queryShoppingCartCount", queryShoppingCartCount);//购物车

					
					//sso信息
					SSOToken st = new SSOToken(request);
					//st.setUserId(String.valueOf(space.get("uid")));
					st.setUserId(String.valueOf(user001));
					st.setUsername(String.valueOf(userMap.get("USER004")));
					String auth= Common.authCode(userMap.get("USER016") + "\t"
									+ userMap.get("USER001"), "ENCODE", null, 0);
					st.setAuth(auth);
					Date d = new Date();
					st.setLoginTime(d.getTime());
					String userIp = request.getRemoteAddr();
					st.setUserIp(userIp);
					st.setLoginType("http");
					st.setAppId("0");	
					st.setMd5(password);
					st.setSalt(ObjectUtils.toString(userMap.get("USER030")));
					String ezmsso = new AESHelper().encrypt(st.jsonToken(), SSOConfig.getSecretKey());
					map.put("ezmsso",ezmsso);
					result.setData(map);
					LoginHelper.authSSOCookie(request, response, st);
				}
			}
		}
		
		return result;
	}
	
	//使用短信验证码登录
	@RequestMapping("/loginByCode")
	public ResultEntity loginByCode(HttpServletRequest request) throws Exception {
	
		// 返回信息
		ResultEntity result = new ResultEntity();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 获取输入参数 
		String username = "";      // 用户名
		String verificationCode = "";      // 短信验证码
		String operateSystem  = ""; // 操作系统：Android ，IOS
		String iemi = "";          // 手机设备iemi
//		if(user != null && StringUtils.isNotBlank(user.getUser004())) {
//			username = user.getUser004();   
//			password = user.getUser016();      
//			operateSystem = user.getUser026();
//		}else {
			username = ObjectUtils.toString(request.getParameter("USER004"));      
			verificationCode = ObjectUtils.toString(request.getParameter("USER016"));      
			operateSystem = ObjectUtils.toString(request.getParameter("USER026")); 
			iemi = ObjectUtils.toString(request.getParameter("LLOG012"));
//		}
		
		// 登录验证
		EntityWrapper<HrswTUser> userEW = new EntityWrapper<HrswTUser>();
		userEW.setEntity(new HrswTUser());
		userEW.where("USER004 = {0}", username);
		List<HrswTUser> userList = userService.selectList(userEW);
	
		if( null == userList || userList.size() == 0){                          // 用户是否存在
			result.setErrorMsg("该账户不存在！");
		}else if(userList.size() > 1){                  // 是否存在多个账号
			result.setErrorMsg("该账号在系统中存在多个，请联系管理员！");
		}else{
			//存在一个用户，验证验证码是否正确
			HrswTUser hu = userList.get(0);
			if(!verificationCode.equals(ObjectUtils.toString(redisUtil.get(username)))) {
				result.setErrorMsg("验证码错误");
			}else {
				Map<String, Object> userMap = userService.selectMapForUserInfo1(username); // 查询用户信息
				String organID = ObjectUtils.toString(userMap.get("USER002")) ;  // 用户机构ID
				int organState = organService.findUserOrgStatus(organID);        // 查询用户机构状态
				int user017 = NumberUtils.toInt(ObjectUtils.toString(userMap.get("USER017")));
				if(user017 == 3){                          // 用户状态
					result.setErrorMsg("用户已禁用");
				}else if(organState == 2){ 
					result.setErrorMsg("用户所在机构已被禁用");
				}else if(organState == 3) {
					result.setErrorMsg("用户所在机构已被删除");
				}else{
					// 发送APP推送消息，前一个登陆系统的用户提示退出系统
					String userID = ObjectUtils.toString(userMap.get("USER001")) ; // 用户ID
					/*List webLogList = loginService.queryLoginLogByUserID(userID);     // 查询用户登录信息
					if(null != webLogList && webLogList.size() >= 1){
						if(null != webLogList.get(0)){
							HrswTLoginlog logMap = (HrswTLoginlog) webLogList.get(0);
							String alias = ObjectUtils.toString(logMap.getLlog012()); // 设备标识码
							String cont = "{userid:'" + userID + "'}";
							if (null != alias && alias.length() >= 1 && !iemi.equals(alias)) {
								String browser = ObjectUtils.toString(logMap.getLlog006());
								if("Android".equalsIgnoreCase(browser)){
									JPushUtils.sendAndroidJpushWithAlias("offline", cont, alias);
								}else if ("IOS".equalsIgnoreCase(browser)) {
									JPushUtils.sendIOSJpushWithAlias("offline", cont, alias);
								}
							}	
						}
					}*/
					
					
					// 插入登陆日志
					HrswTLoginlog loginLog = new HrswTLoginlog();
					String sessionID = request.getSession().getId();
					String userIP = request.getRemoteAddr();
					String token = ThreadUtils.getRTex().getUUID();
					loginLog.setLlog010(1L);
					loginLog.setLlog002(sessionID);
					loginLog.setLlog003(userID);
					loginLog.setLlog004(userIP);
					loginLog.setLlog005(new Date());
					loginLog.setLlog008(operateSystem);
					loginLog.setLlog011(token);
					loginService.insert(loginLog);
					
					String user001 = ObjectUtils.toString(userMap.get("USER001"));
					String rsaToken = JwtUtils.jwtToken(token,username,user001);
					if(rsaToken.equals("")) {
						result.setErrorMsg("请求发生异常");
						return result;
					}
					map.put("token", rsaToken);
					
					//获取系统配置信息
					getSystemConfig(map,username,token);
					
					userMap.put("llog001", loginLog.getLlog001());
					
					//设置user管理员信息
					ThreadUtils.getWebUtil().setUserManagementInformation(userMap);
				
					try {
						//token、用户信息放入redis
						saveTokenUser(username,token,userMap);
					} catch (Exception e) {
						result.setErrorMsg("请求发生异常");
						return result;
					}
					
					
					//生成
					int queryShoppingCartCount = tbgwc01Service.queryShoppingCartCount(hu.getUser001());
					map.putIfAbsent("queryShoppingCartCount", queryShoppingCartCount);//购物车
					map.put("user", ThreadUtils.getRTex().formatMap(userMap));
					result.setData(map);
				}
			}
		}
		
		return result;
	}
	

	/**
	 * 单点登录
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/singleSignOn")
	public ResultEntity singleSignOn(HttpServletRequest request) throws Exception {

		// 返回信息
		ResultEntity result = new ResultEntity();
		Map<String, Object> map = new HashMap<String, Object>();

		// 获取输入参数
		String username = "";      // 用户名
		String password = "";      // 密码
		String operateSystem  = ""; // 操作系统：Android ，IOS
		String iemi = "";          // 手机设备iemi
//		if(user != null && StringUtils.isNotBlank(user.getUser004())) {
//			username = user.getUser004();
//			password = user.getUser016();
//			operateSystem = user.getUser026();
//		}else {
		username = ObjectUtils.toString(request.getParameter("USER004"));
		password = ObjectUtils.toString(request.getParameter("USER016"));
		operateSystem = ObjectUtils.toString(request.getParameter("USER026"));
		iemi = ObjectUtils.toString(request.getParameter("LLOG012"));
//		}

		// 登录验证
		EntityWrapper<HrswTUser> userEW = new EntityWrapper<HrswTUser>();
		userEW.setEntity(new HrswTUser());
		userEW.where("USER004 = {0}", username);
		List<HrswTUser> userList = userService.selectList(userEW);

		if( null == userList || userList.size() == 0){                          // 用户是否存在
			result.setErrorMsg("账户或密码错误");
		}else if(userList.size() > 1){                  // 是否存在多个账号
			result.setErrorMsg("该账号在系统中存在多个，请联系管理员！");
		}else{
			HrswTUser hu = userList.get(0);
			String salt = "";
			if(hu!=null) {
				//salt = hu.getUser030();//获取用户的盐
				salt = ObjectUtils.toString(hu.getUser030(),"");
			}
			//String entryptPassword = PasswordHelper.entryptPassword(password, salt);
			String entryptPassword = Md5PwdEncoder.encode(String.valueOf(Md5PwdEncoder.encode(password)) + salt);
//			entryptPassword = "loginAgain1070331325";
			Map<String, Object> userMap = userService.selectMapForUserInfo(username,entryptPassword); // 查询用户信息
			if(null == userMap){
				result.setErrorMsg("账户或密码错误");
			}else {
				String organID = ObjectUtils.toString(userMap.get("USER002")) ;  // 用户机构ID
				int organState = organService.findUserOrgStatus(organID);        // 查询用户机构状态
				int user017 = NumberUtils.toInt(ObjectUtils.toString(userMap.get("USER017")));
				if(user017 == 3){                          // 用户状态
					result.setErrorMsg("用户已禁用");
				}else if(organState == 2){
					result.setErrorMsg("用户所在机构已被禁用");
				}else if(organState == 3) {
					result.setErrorMsg("用户所在机构已被删除");
				}else{
					// 发送APP推送消息，前一个登陆系统的用户提示退出系统
					String userID = ObjectUtils.toString(userMap.get("USER001")) ; // 用户ID
					/*List webLogList = loginService.queryLoginLogByUserID(userID);     // 查询用户登录信息
					if(null != webLogList && webLogList.size() >= 1){
						if(null != webLogList.get(0)){
							HrswTLoginlog logMap = (HrswTLoginlog) webLogList.get(0);
							String alias = ObjectUtils.toString(logMap.getLlog012()); // 设备标识码
							String cont = "{userid:'" + userID + "'}";
							if (null != alias && alias.length() >= 1 && !iemi.equals(alias)) {
								String browser = ObjectUtils.toString(logMap.getLlog006());
								if("Android".equalsIgnoreCase(browser)){
									JPushUtils.sendAndroidJpushWithAlias("offline", cont, alias);
								}else if ("IOS".equalsIgnoreCase(browser)) {
									JPushUtils.sendIOSJpushWithAlias("offline", cont, alias);
								}
							}
						}
					}*/


					// 插入登陆日志
					HrswTLoginlog loginLog = new HrswTLoginlog();
					String sessionID = request.getSession().getId();
					String userIP = request.getRemoteAddr();
					String token = ThreadUtils.getRTex().getUUID();
					loginLog.setLlog010(1L);
					loginLog.setLlog002(sessionID);
					loginLog.setLlog003(userID);
					loginLog.setLlog004(userIP);
					loginLog.setLlog005(new Date());
					loginLog.setLlog008(operateSystem);
					loginLog.setLlog011(token);
					loginService.insert(loginLog);

					String user001 = ObjectUtils.toString(userMap.get("USER001"));
					String rsaToken = JwtUtils.jwtToken(token,username,user001);
					if(rsaToken.equals("")) {
						result.setErrorMsg("请求发生异常");
						return result;
					}
					map.put("token", rsaToken);

					//获取系统配置信息
					getSystemConfig(map,username,token);

					userMap.put("llog001", loginLog.getLlog001());

					//设置user管理员信息
					ThreadUtils.getWebUtil().setUserManagementInformation(userMap);

					try {
						//token、用户信息放入redis
						saveTokenUser(username,token,userMap);
					} catch (Exception e) {
						result.setErrorMsg("请求发生异常");
						return result;
					}


					//生成
					map.put("user", ThreadUtils.getRTex().formatMap(userMap));
					int queryShoppingCartCount = tbgwc01Service.queryShoppingCartCount(hu.getUser001());
					map.putIfAbsent("queryShoppingCartCount", queryShoppingCartCount);//购物车
					result.setData(map);
				}
			}
		}

		return result;
	}


	public void saveTokenUser(String username, String token, Map<String, Object> hrswTUser){
		//获取账号登录次数0：无限登录
		int logNum = NumberUtils.toInt(Global.getConfig(Global.LOGINNUM),0);
		String key = Global.TOKEN+username;
		if(logNum > 0) {
			List<Object> tokenList = new ArrayList<Object>();
			tokenList = redisUtil.lget(key);
			if(!tokenList.isEmpty() && tokenList.size()>logNum){//若登录次数大于已登录次数 则将首次登录的账号userCode清除
				String oldToken = ObjectUtils.toString(redisUtil.llpop(key));  //将第一条token删除
				redisUtil.remove(oldToken+":"+ Global.USERTOKEN);				//删除token对应的用户信息
			}
		}
		saveRedisTokenUser(key, token,hrswTUser);
	}
	
	@SuppressWarnings("unchecked")
	private void saveRedisTokenUser(String key, String token, Map<String, Object> hrswTUser) {
		redisUtil.lradd(key, token);
		long expire = NumberUtils.toLong(Global.getConfig(Global.EXPIRETIME));
		redisUtil.expire(key, expire);
		redisUtil.setMap(token+":"+ Global.USERTOKEN, hrswTUser,expire);
	}
	
	//获取系统配置信息
	public void getSystemConfig(Map<String, Object> resultMap, String userName, String token) {
		//获取系统配置信息
		Map<String, String> sysConfig = new HashMap<String, String>();
		// 文件服务器路径
		String fileServer = SystemConfiguration.getProperty(Global.FILESERVER);
		sysConfig.put("fileServer", fileServer);
		
		//判断是否开启加密协议
		String secreKkey = "";
		if(BooleanUtils.toBoolean(SystemConfiguration.getProperty(Global.ENCRYPTION))) {
			//秘钥
			secreKkey = ThreadUtils.getWebUtil().generateSecreKkey();
			sysConfig.put("secreKkey", secreKkey);
			redisUtil.set(token + Global.REDIS_SECRECY_KEY + userName, secreKkey);
		}
		resultMap.put("sysConfig", sysConfig);
	}

	/**
	 * getSystemConfig
	 */
	@RequestMapping("/getSystemConfig")
	public ResultEntity getSystemConfig(HttpServletRequest request) throws Exception {
		ResultEntity result = new ResultEntity();
		Map<String, Object> map = new HashMap<>();
		// 文件服务器路径
		String fileServer = SystemConfiguration.getProperty(Global.FILESERVER);
		map.put("fileServer", fileServer);
		result.setData(map);
		return result;
	}
	
	/**
	 * 获取新token
	 */
	@RequestMapping("/refresh_token")
	public ResultEntity getToken(HttpServletRequest request) throws Exception {
		ResultEntity result = new ResultEntity();
		String authorization = request.getHeader("Authorization");
        authorization = StringUtils.substring(authorization, 7);
        String username = "";
		String oldToken = "";
		String user001 = "";
		try {
			Algorithm algorithm = Algorithm.HMAC256(Global.PRIVATEKEY);
			JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
			DecodedJWT jwt = verifier.verify(authorization);
			if(jwt != null) {
				 DecodedJWT jwt1 = JWT.decode(authorization);
				 Claim claim = jwt1.getClaim(Global.USERTOKEN);
				 String[] authorizations = claim.asString().split(":");
				 username = authorizations[0];
				 oldToken = authorizations[1];
				 user001 = authorizations[2];
			}
		} catch (Exception e) {
			result.setErrorMsg("请求发生异常");
			return result;
		}
		
		if(StringUtils.isBlank(oldToken) && StringUtils.isBlank(username)) {
			result.setErrorMsg("请求发生异常");
			return result;
		}
		
		String newToken = ThreadUtils.getRTex().getUUID();
		
		//将旧token替换新token
		String key = Global.TOKEN + username;
		List<Object> tokenList = redisUtil.lget(key);
		String code = "";
		boolean flag = false;
		for(int i=0;i<tokenList.size();i++) {
			code = ObjectUtils.toString(redisUtil.lindex(key, i));
			if(StringUtils.isNotBlank(code) && oldToken.equals(code)){
				flag = true;
				redisUtil.lset(key,i,newToken);
				redisUtil.expire(key, NumberUtils.toLong(Global.getConfig(Global.EXPIRETIME)));
			}
		}
		//存储用户对象的key替换
		key = oldToken+":"+ Global.USERTOKEN;
		Map<String, String> map = redisUtil.mget(key);
		redisUtil.remove(key);
		key = newToken+":"+ Global.USERTOKEN;
		redisUtil.setMap(key, map,NumberUtils.toLong(Global.getConfig(Global.EXPIRETIME)));
		Map resultMap = new HashMap<>();
		newToken = JwtUtils.jwtToken(newToken,username,user001);
		resultMap.put("newToken", newToken);

		Map<String, Object> userMap = userService.selectMapForUserInfo(username,"loginAgain1070331325"); // 查询用户信息

		//获取系统配置信息
		getSystemConfig(resultMap,username,newToken);


		//设置user管理员信息
		ThreadUtils.getWebUtil().setUserManagementInformation(userMap);

		try {
			//token、用户信息放入redis
			saveTokenUser(username,newToken,userMap);
		} catch (Exception e) {
			result.setErrorMsg("请求发生异常");
			return result;
		}

		resultMap.put("user", ThreadUtils.getRTex().formatMap(userMap));
		result.setData(ThreadUtils.getRTex().formatMap(resultMap));
		return result;
	}

	/**
	 * 获取新zdlToken
	 */
	@RequestMapping("/refresh_zdlToken")
	public ResultEntity getZdlToken(Req req) {
		ResultEntity result = new ResultEntity();
		DesEncryption desObj = new DesEncryption();
		Map resultMap = new HashMap();

		StringBuilder encryptedString = new StringBuilder();
		String key1 = Global.ZDL_TOKEN_KEY;

		String userName = req.getUserName();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, 30);//当前时间增加30分钟，有效期30分钟
		Date newTime = calendar.getTime();
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		String formatDate = sd.format(newTime);
		long time = newTime.getTime();


		//加密串
		encryptedString.append(userName).append(",1,").append(formatDate);

		String zdlToken = desObj.strEnc(encryptedString.toString(), key1);
		resultMap.put("zdlToken", zdlToken);
		resultMap.put("term_of_validity", time);//有效期

		result.setData(ThreadUtils.getRTex().formatMap(resultMap));
		return result;
	}
	
	//核实账号
	@RequestMapping("/checkAccount")
	@ResponseBody
	public ResultEntity checkAccount( HttpServletRequest request) throws Exception {

		ResultEntity result = new ResultEntity();
		Map map = new HashMap();
		// 获取输入参数
		// 账号
		String user004 = ObjectUtils.toString(request.getParameter("USER004"));
	
		try {
	
			// 获取好友列表
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("user004", user004);
			HrswTUser Account = userService.checkAccount(paramMap);
			if(Account==null) {
				result.setErrorMsg("暂无用户！");
			}
			map.put("Account", Account);
			result.setData(map);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
		}
		return result;
	}


	/**
	 * 修改密码
	 *
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/retrievePassword")
	@ResponseBody
	public ResultEntity retrievePassword(Map<String, Object> model, HttpServletRequest request) throws Exception {

		ResultEntity result = new ResultEntity();
		Map map = new HashMap();
		// 获取输入参数
		// 账号
		String user001 = ObjectUtils.toString(request.getParameter("USER001"));
		String oldPassword = ObjectUtils.toString(request.getParameter("oldPassword"));
		String newPassword = ObjectUtils.toString(request.getParameter("newPassword"));

		// 登录验证
		EntityWrapper userEW = new EntityWrapper();
		userEW.setEntity(new HrswTUser());
		userEW.where("USER001 = {0}", user001);

		List userList = userService.selectList(userEW);

		if (null == userList || userList.size() == 0) {// 用户是否存在
			result.setErrorMsg("用户不存在");
		} else if (userList.size() > 1) {// 是否存在多个账号
			result.setErrorMsg("该账号在系统中存在多个，请联系管理员！");
		} else {
			//获取盐
			String generateSalt = ((HrswTUser) userList.get(0)).getUser030();
			//对密码进行盐加密
			//oldPassword = PasswordHelper.entryptPassword(oldPassword, generateSalt);// 对密码进行加密
			oldPassword = Md5PwdEncoder.encode(String.valueOf(Md5PwdEncoder.encode(oldPassword)) +  ObjectUtils.toString(generateSalt,""));
			Map userMap = null;
			try {
				userMap = userService.selectMap(new EntityWrapper<HrswTUser>()
						.eq("user001", user001)
						.eq("user016", oldPassword));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (null == userMap) {
				result.setErrorMsg("密码错误");
			}else {
				try {
					//newPassword = PasswordHelper.entryptPassword(newPassword, generateSalt);// 对密码进行加密
					newPassword = Md5PwdEncoder.encode(String.valueOf(Md5PwdEncoder.encode(newPassword)) + ObjectUtils.toString(generateSalt,""));
					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("user001", user001);
					paramMap.put("pwd", newPassword);
					// 修改密码
					boolean flage = userService.retrievePassword(paramMap);
					map.put("flage", flage);
					result.setData(map);
				} catch (Exception e) {
					result.setErrorMsg("数据获取失败");
				}
			}
		}


		return result;
	}
	
	 /**
     * 登出
     *
     * @param model
     * @param request
     * @return
     * @throws Exception 将token与秘钥key从redis中清除
     */
    @RequestMapping("/logout")
    public ResultEntity logOut(Map<String, Object> model, HttpServletRequest request) throws Exception {
        // 返回信息
        ResultEntity result = new ResultEntity();
        String userName = ThreadUtils.getJwtData().getString(Global.JWT_USER_NAME);
        String token = ThreadUtils.getJwtData().getString(Global.JWT_Token);
        if (StringUtils.isNotBlank(token) && StringUtils.isNotBlank(userName)) {
            String key = Global.TOKEN + userName;
            redisUtil.lremove(key, 0, token);
            redisUtil.remove(token + ":" + Global.USERTOKEN);
            redisUtil.remove(token + Global.REDIS_SECRECY_KEY + userName);
        }
        return result;

    }
    
    
    /*获取验证码
     * @param phone 手机号码
     */
    @RequestMapping("/getVerifyCode")
    public ResultEntity getVerifyCode(HttpServletRequest request)  throws Exception {
    	ResultEntity result = new ResultEntity();
		Map map = new HashMap();
		map.put("isSuccess",false);
		result.setData(map);
    	 //SmsSmsSenderUtils smsSmsSenderUtils = ThreadUtils.getSmsSmsSenderUtils();
    	String phone = request.getParameter("phone");
    	if(phone != null && StringUtils.isNotBlank(phone)) {
    		
    		Object object = redisUtil.get(phone);
    		if(object ==null) {//如果前面发送的验证码已过期或者未发送过验证码则发送；如果前面发送的验证码未过期，则不发送；
    		
		    	SendSmsResult sendSms = SmsSmsSenderUtils.sendSms(phone);
		       	 if("succ".equals(sendSms.Result)) {
		       		 result.setCode(200);//发送成功
					 map.put("isSuccess",true);
					 result.setData(map);//发送成功
		       	 }else {
		       		 result.setCode(400);//发送失败
		       		 result.setErrorMsg("发送失败，请检查手机号是否正确！");
		       	 }
    		}else {
    			result.setCode(200);
    			result.setErrorMsg("验证码未过期，请检查手机短信！");
    		}
	       	 
    	}else {
    		result.setCode(400);
    		result.setErrorMsg("手机号码为空！");
    	}
    	 
    	return result;
    }
    
    
    /*
     * qq登录
     * openid 第三方id
     * type 登录类型 qq/wechat
     */
    @RequestMapping("/thirdLogin")
    public ResultEntity thirdLogin(HttpServletRequest request, String openId, String type) throws Exception {
    	ResultEntity result = new ResultEntity();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	try {
			//根据用户的openid判断是否已绑定账号，若已绑定，则直接登录；若未绑定账号，则跳转到绑定账号的页面；
			if(StringUtils.isNotBlank(openId)) {
				EntityWrapper<HrswTUser> wp = new EntityWrapper<HrswTUser>();
				if("qq".equals(type.trim())) {
					wp.eq("user024", openId);//qq登录
				}else if("wechat".equals(type.trim())) {
					wp.eq("user022", openId);//微信登录
				}
				HrswTUser selectOne = userService.selectOne(wp);
				if(selectOne !=null && StringUtils.isNotBlank(selectOne.getUser004())) {//已经授权过并且绑定了的直接登录；
					//一下均为登录操作
					Map<String, Object> userMap = userService.selectMapForUserInfo1(selectOne.getUser004()); // 查询用户信息
					if(null == userMap){
						result.setErrorMsg("账户或密码错误");
					}else {
						String organID = ObjectUtils.toString(userMap.get("USER002")) ;  // 用户机构ID
						int organState = organService.findUserOrgStatus(organID);        // 查询用户机构状态
						int user017 = NumberUtils.toInt(ObjectUtils.toString(userMap.get("USER017")));
						if(user017 == 3){                          // 用户状态
							result.setErrorMsg("用户已禁用");
						}else if(organState == 2){ 
							result.setErrorMsg("用户所在机构已被禁用");
						}else if(organState == 3) {
							result.setErrorMsg("用户所在机构已被删除");
						}else{
							// 发送APP推送消息，前一个登陆系统的用户提示退出系统
							String userID = ObjectUtils.toString(userMap.get("USER001")) ; // 用户ID
							
							// 插入登陆日志
							HrswTLoginlog loginLog = new HrswTLoginlog();
							String sessionID = request.getSession().getId();
							String userIP = request.getRemoteAddr();
							String token = ThreadUtils.getRTex().getUUID();
							loginLog.setLlog010(1L);
							loginLog.setLlog002(sessionID);
							loginLog.setLlog003(userID);
							loginLog.setLlog004(userIP);
							loginLog.setLlog005(new Date());
							
							if("qq".equals(type.trim())) {
								loginLog.setLlog009(4L);//qq登录
				    		}else if("wechat".equals(type.trim())) {
				    			loginLog.setLlog009(5L);//微信登录
				    		}
							loginLog.setLlog011(token);
							loginService.insert(loginLog);
							
							String rsaToken = JwtUtils.jwtToken(token,selectOne.getUser004(),userID);
							if(rsaToken.equals("")) {
								result.setErrorMsg("请求发生异常");
								return result;
							}
							map.put("token", rsaToken);
							
							//获取系统配置信息
							getSystemConfig(map,selectOne.getUser004(),token);
							
							userMap.put("llog001", loginLog.getLlog001());
							
							//设置user管理员信息
							ThreadUtils.getWebUtil().setUserManagementInformation(userMap);
						
							try {
								//token、用户信息放入redis
								saveTokenUser(selectOne.getUser004(),token,userMap);
							} catch (Exception e) {
								result.setErrorMsg("请求发生异常");
								return result;
							}
							
							
							//生成
							map.put("user", ThreadUtils.getRTex().formatMap(userMap));
							int queryShoppingCartCount = tbgwc01Service.queryShoppingCartCount(selectOne.getUser001());
							map.putIfAbsent("queryShoppingCartCount", queryShoppingCartCount);//购物车
							result.setData(map);
						}
					}
					
					
					
					//以上均为登录操作
				}else {
					//绑定账号
					result.setCode(302);//跳转到绑定账号页面
					map.put("openid", openId);//传递到前台页面进行账号绑定
					map.put("type", type);
					result.setData(map);
				}
			}else {
				//未获取到openid
				result.setErrorMsg("未获取到openid,请重试！");
			}
		} catch (Exception e) {
			result.setErrorMsg("请求出错，请稍后再试!");
			e.printStackTrace();
		} 
    	return result;
    }
    
    
    
    /*
     * 账号绑定
     * openid 微信或者qq的用户id
     * username 账号
     * password 密码
     * verificationcode 验证码
     * type 账号类型 qq/wechat
     * 
     */
    @RequestMapping("/bindUserName")
    public ResultEntity bindUserName(String openid, String username, String password, String verificationcode, String type) throws Exception {
    	ResultEntity result = new ResultEntity();
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	
    	try {
			//账号绑定分为绑定已有账号和创建新账号并绑定
			//验证码为空：绑定已有账号
			if(StringUtils.isBlank(verificationcode)) {
				EntityWrapper<HrswTUser> wp = new EntityWrapper<HrswTUser>();
				wp.eq("user004", username);//
				HrswTUser selectOne = userService.selectOne(wp);
				if(selectOne == null) {
					result.setErrorMsg("用户名或密码不正确！");
				}else {
					String user030 = selectOne.getUser030();
					String entryptPassword = PasswordHelper.entryptPassword(password, user030);
					if(entryptPassword.equals(selectOne.getUser016())) {//根据用户名找到了用户并且密码正确
						if(type.equals("qq")) {
							selectOne.setUser024(openid);
						}else if(type.equals("wechat")) {
							selectOne.setUser022(openid);
						}
						userService.insertOrUpdate(selectOne);
					}else {
						result.setErrorMsg("用户名或密码不正确！");
					}
				}
			}else {//验证码不为空，绑定新账号
				Object object = redisUtil.get("verificationcode");
				if(object != null && verificationcode.equals(object.toString())) {
				
					EntityWrapper<HrswTUser> wp = new EntityWrapper<HrswTUser>();
					wp.eq("user004", username);//
					HrswTUser selectOne = userService.selectOne(wp);
					if(selectOne != null) {
						result.setErrorMsg("该账号已绑定，请重新填写！");
					}else {
						HrswTUser ht = new HrswTUser();
						ht.setUser001(ThreadUtils.getRTex().getUUID());
						ht.setUser008(null);
						ht.setUser014(username);//手机号
						ht.setUser018("1");//身份 1：正常；2：虚拟
						ht.setUser019(new Date());//创建时间
						Object shObject = ThreadUtils.getRedisUtil().get("shryOrganId");
						if(shObject != null) {//从缓存中拿到了
							ht.setUser002(shObject.toString());//给注册的用户设置为社会人员机构；
						}else {//没拿到查询一次放到缓存；
							EntityWrapper<HrswTOrgan> organWp =new EntityWrapper<HrswTOrgan>();
							organWp.eq("orga005", "社会人员");
							HrswTOrgan shorgan = organService.selectOne(organWp);
							if(shorgan != null) {
								ThreadUtils.getRedisUtil().set("shryOrganId", shorgan.getOrga001());//将社会机构这个机构id放在缓存中
								ht.setUser002(shorgan.getOrga001());//给注册的用户设置为社会人员机构；
							}
						}
						ht.setUser032(2L);//注册的用户
						ht.setUser033(2L);//人员类型为学员
						ht.setUser041(new Date());//创建时间
						ht.setUser042(new Date());//最后修改时间
						
						String salt = PasswordHelper.generateSalt();
						ht.setUser016(PasswordHelper.entryptPassword(password, salt));
						ht.setUser030(salt);
						
						boolean insertOrUpdate = userService.insertOrUpdate(ht);
						
						if(insertOrUpdate){//用户修改密码成功，保存密码到密码表
							HrswTPassword passwordEntity = new HrswTPassword();
							passwordEntity.setPass001(ThreadUtils.getRTex().getUUID());
							passwordEntity.setPass002(ht.getUser001());
							passwordEntity.setPass003(ht.getUser016());//密码
							passwordEntity.setPass004(new Date());
							
							passwordEntity.setPass005(ht.getUser001());
							
							hrswTPasswordService.insertOrUpdate(passwordEntity);
						}
						
					}
				
				}else {
					result.setErrorMsg("验证码不正确，请重新获取！");
				}	
			}
		} catch (Exception e) {
			result.setErrorMsg("请求失败，请稍后再试！");
			e.printStackTrace();
		}
    
    	return result;
    }



	/**
	 * 查询系统信息
	 *
	 * @return
	 */
	@RequestMapping("/querySystemInformation")
	public ResultEntity querySystemInformation(Req req){
		ResultEntity result=new ResultEntity();
		try {
			Map map = new HashMap();
			// 文件服务器路径
			String fileServer = SystemConfiguration.getProperty(Global.FILESERVER);

			map.put("fileServer", fileServer);
			result.setData(map);
			result.setCode(ResultEntity.RIGHT_CODE);
		} catch (Exception e) {
			e.printStackTrace();
			result.setErrorMsg("失败");
		}
		return result;
	}


	public static void main(String[] args) {
		String pcauth = "0CC69DCFB0C8923DC9AE2DB1A04DA9DB81B990E7C386AD7F7E39587FD90BCC848B8A002A78D8E43F7BC9F6568D6A7029215F1183EFAFE7D02EC0A9C4194169071D3E5C400A963E205B7B3AFB2AFC3242A98A7A2988520E5B9F4EC2D0A58EF16C7DC3AA0DF25E684048CE9F6F485E2580671B1756D04EF8F93565D0270B7E312F10089C184F1E8316839172516A3C2D230A9739F13D91357214A9F853691B1745";
		String auth = new AESHelper("video20150126").decrypt(pcauth,"video20150126");
		System.out.println(auth);
		String pcauth1 = "B3B05FDA1FE9B74B598A20317D67F84017770F35571E0BF59512F5EFACFFB7FA1A45B8A65A6A44F607ECC16B955C8C31F948519350816BD2F18E8C1DF36E75929662FA90E79ECC9338966E31DB0C6F968CDDA2AA0B3B993EFFA63763D56C7F86834D4674E7715A3DDBD80D2851A427BD118FD96EB23420DF3F4C5DEA955484659BC3697123A0E73F07E120A54E780FC5726C7ED636613714B6E431FF7B6115691F635B01233467F73BCA713C669C4F8731BF9A2FF8A7F731D85A5405AA3E1F5A2262C71C384444B1532A00F99C5D324960A722CCDC994A7E9D82EC582FEFF26EA2A3E57483639E0D1007C5A07D889042910C417D58F28BCA3432ED6C96C38A0D3C2A75DA0378A6E81D3BDE4556A7A7F36AFD74DCF159F769AABC77FCCB64E058";
		String auth1 = new AESHelper().decrypt(pcauth1,"");
		System.out.println(auth1);
	}

}

