/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.huarui.common.config;

import com.huarui.common.utils.PropertiesLoader;
import com.huarui.common.utils.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 * @author ThinkGem
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("application.properties");

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	
	/**
	 * 私钥key
	 */
	public static final String ENCRYPTION = "encryptionprotocol";
	
	/**
	 * 文件服务器地址
	 */
	public static final String FILESERVER = "server.fileServer";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 手机端账号登录次数
	 */
	public static final String LOGINNUM = "login.number";
	
	/**
	 * 用户token key键
	 */
	public static final String TOKEN = "user:token:expires";
	
	/**
	 * 手机token的有效时间
	 */
	public static final String EXPIRETIME = "app.token.expireTime";
	
	/**
	 * token+USERTOKEN作为用户信息的key
	 */
	public static final String USERTOKEN = "user:token";
	
	/**
	 * 存储redis秘钥key
	 */
	public static final String REDIS_SECRECY_KEY = ":secrecy:key:";

	/**
	 * AES加密偏移量
	 */
	public static final String AES_IV = "1029384756qwezxc";

	/**
	 *
	 */
	public static final String ALGORITHM = "AES";
	/**
	 * 算法/模式/补码方式
	 */
	public static final String ALGORITHM_PROVIDER = "AES/CBC/PKCS5Padding";

	/**
	 * aes加密key
	 */
	public static final String AES_KEY  ="huarui!@#$%^&123";

	/**
	 * jwt加密key
	 */
	public static final String PRIVATEKEY  ="privatehuaruiapp#@$!!";

	/**
	 * 生成zdlToken的秘钥key
	 */
	public static final String ZDL_TOKEN_KEY = "7368i17zws9ea1qei9c6wddm2jrw2z3q";
	
	/**
	 * 上传文件临时路劲
	 */
	public static final String WEBSITE_UPLOADPATH  ="website.uploadpath";
	
	/**
	 * 获取Authorization key
	 */
	public static final String AUTHORIZATION  ="Authorization";
	
	/**
	 * 获取jwt用户名 key
	 */
	public static final String JWT_USER_NAME  ="jwt:username";
	public static final String JWT_Token  ="jwt:token";
	public static final String JWT_USER_ID  ="jwt:userid";
	public static String SECRECY_KEY = "huarui!@#$%^&123";//默认的秘钥
	public static int SECRECY_ERROR_CODE = 600; //发送加密数据解密失败CODE
	public static int REDIS_ERROR_CODE = 601; //连接redis失败
	public static String TM_ENCRYPTION_KEY = "7368i17zws9ea1qei9c6wddm2jrw2z3q"; //通铭接口返回加密秘钥
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		//寻找值顺序   -->数据库  -->配置文件
		String value = map.get(key);
		if (value == null){
			value = SystemConfiguration.getProperty(key);//在数据库中找
			if(value == null) {
				value = loader.getProperty(key);//在配置文件中找
			}
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	
    
	/**
	 * 页面获取常量
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	
    /**
     * 获取工程路径
     * @return
     */
    public static String getProjectPath(){
    	// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)){
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null){
				while(true){
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()){
						break;
					}
					if (file.getParentFile() != null){
						file = file.getParentFile();
					}else{
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
    }
	
}
