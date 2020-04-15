package com.huarui.common.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.*;

@Service
public class EmchatUtils {
	
	private String corp_id = "";
	private String app_id = "";
	private String url_base = "";
	private String client_id = "";
	private String client_secret = "";
	private String access_token = "";
	
	@PostConstruct
	public void init() {
		try {
			Properties versionProperties = new Properties();
			InputStream in = EmchatUtils.class.getClassLoader().getResourceAsStream("application.properties");
			versionProperties.load(in);
			corp_id = versionProperties.getProperty("ORG_NAME");
			app_id = versionProperties.getProperty("APP_NAME");
			url_base = "https://a1.easemob.com/" + corp_id + "/"+app_id;
			client_id = versionProperties.getProperty("CLIENT_ID");
			client_secret = versionProperties.getProperty("CLIENT_SECRET");
			
			getAccessToken();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	} 
	
	public void getAccessToken() {
		String access_token_url = "token";
		String access_token_post = "{\"grant_type\":\"client_credentials\",\"client_id\":\"" + client_id  + "\",\"client_secret\":\"" + client_secret + "\"}";
		EmchatRestResult rest = RestPost(access_token_url,access_token_post);
		if(rest.getCode()==200) {
			access_token = (String)rest.getMessageMap().get("access_token");
		}
	}
	
	//rest请求-get
	public EmchatRestResult RestGet(String url) {
		EmchatRestResult result = new EmchatRestResult();
        try {
    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpGet postRequest = new HttpGet(url_base + "/" + url);
    		
    		for(int i=0;i<2;i++) {
	    		if(!"".equals(access_token)) {
	    			postRequest.setHeader("Authorization", "Bearer " + access_token);
	    		}
	
	    		HttpResponse response = httpClient.execute(postRequest);
	    		
	    		result.setCode(response.getStatusLine().getStatusCode());
	
	    		String output = IOUtils.toString(response.getEntity().getContent(),"utf-8");
	    		result.setMessage(output);
	    		
	    		if(result.getCode()!=401) break;
    		}

    		httpClient.getConnectionManager().shutdown();
    	  } catch (Exception e) {

    		e.printStackTrace();
    	  }
        
        return result;
	}
	
	//rest请求-post
	public EmchatRestResult RestPost(String url, String post) {
		EmchatRestResult result = new EmchatRestResult();
        try {
    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPost postRequest = new HttpPost(url_base + "/" + url);

    		if(post!=null && !StringUtils.isNotEmpty("")) {
    			StringEntity input = new StringEntity(post,"utf-8");
    			input.setContentType("application/json");
    			postRequest.setEntity(input);
    		}
    		
    		for(int i=0;i<2;i++) {
	    		if(!"".equals(access_token)) {
	    			postRequest.setHeader("Authorization", "Bearer " + access_token);
	    		}
	
	    		HttpResponse response = httpClient.execute(postRequest);
	    		
	    		result.setCode(response.getStatusLine().getStatusCode());
	
	    		String output = IOUtils.toString(response.getEntity().getContent(),"utf-8");
	    		result.setMessage(output);
	    		
	    		if(result.getCode()!=401) break;
    		}

    		httpClient.getConnectionManager().shutdown();
    	  } catch (Exception e) {

    		e.printStackTrace();
    	  }
        
        return result;
	}
	
	//rest请求-put
	public EmchatRestResult RestPut(String url, String post) {
		EmchatRestResult result = new EmchatRestResult();
        try {
    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPut postRequest = new HttpPut(url_base + "/" + url);

    		if(post!=null && !StringUtils.isNotEmpty("")) {
    			StringEntity input = new StringEntity(post,"utf-8");
    			input.setContentType("application/json");
    			postRequest.setEntity(input);
    		}
    		
    		for(int i=0;i<2;i++) {
	    		if(!"".equals(access_token)) {
	    			postRequest.setHeader("Authorization", "Bearer " + access_token);
	    		}
	
	    		HttpResponse response = httpClient.execute(postRequest);
	    		
	    		result.setCode(response.getStatusLine().getStatusCode());
	
	    		String output = IOUtils.toString(response.getEntity().getContent(),"utf-8");
	    		result.setMessage(output);
	    		
	    		if(result.getCode()!=401) break;
    		}

    		httpClient.getConnectionManager().shutdown();
    	  } catch (Exception e) {

    		e.printStackTrace();
    	  }
        
        return result;
	}
	
	//rest请求-delete
	public EmchatRestResult RestDelete(String url) {
		EmchatRestResult result = new EmchatRestResult();
        try {
        	
    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpDelete postRequest = new HttpDelete(url_base + "/" + url);
    		
    		for(int i=0;i<2;i++) {
        		if(!"".equals(access_token)) {
        			postRequest.setHeader("Authorization", "Bearer " + access_token);
        		}

        		
        		HttpResponse response = httpClient.execute(postRequest);
        		
        		result.setCode(response.getStatusLine().getStatusCode());

        		String output = IOUtils.toString(response.getEntity().getContent(),"utf-8");
        		result.setMessage(output);
	    		
	    		if(result.getCode()!=401) break;
    		}

    		httpClient.getConnectionManager().shutdown();
    	  } catch (Exception e) {

    		e.printStackTrace();
    	  }
        
        return result;
	}
	
	/**
	 * 创建用户
	 * @param username 用户名,nickname 昵称，password 密码
	 * @return 是否创建成功：true成功 false失败
	 */
	public boolean createUser(String username, String nickname, String password) {
		String post = "{\"username\":\"" + username + "\",\"nickname\":\"" + nickname + "\",\"password\":\"" + password + "\"}";
		EmchatRestResult result = RestPost("users", post);
		return result.getCode()==200;
	}
	
	/**
	 * 查询用户
	 * @param username 用户名
	 * @return uuid 用户编号, type 用户类型, created 创建时间, modified 最后修改时间, username 用户名, activated 用户状态
	 */
	public Map queryUser(String username) {
		Map map = null;
		EmchatRestResult result = RestGet("users/" + username);
		if(result.getCode()==200) {
			List data = (List)result.getMessageMap().get("entities");
			if(data.size()>0) {
				map = (Map)data.get(0);
			}
		}
		return map;
	}
	
	/**
	 * 删除用户
	 * @param username 用户名
	 * @return 是否删除成功：true成功 false失败
	 */
	public boolean deleteUser(String username) {
		EmchatRestResult result = RestDelete("users/" + username);
		return result.getCode()==200;
	}
	
	/**
	 * 修改用户昵称
	 * @param username 用户名,nickname 昵称，password 密码
	 * @return 是否创建成功：true成功 false失败
	 */
	public boolean updateUser(String username, String nickname) {
		String post = "{\"nickname\":\"" + nickname + "\"}";
		EmchatRestResult result = RestPut("users/" + username, post);
		return result.getCode()==200;
	}
	
	/**
	 * 添加好友
	 * @param username 用户名,friendname 好友名
	 * @return 是否添加成功：true成功 false失败
	 */
	public boolean createFriend(String username, String friendname) {
		EmchatRestResult result = RestPost("users/" + username + "/contacts/users/" + friendname, null);
		return result.getCode()==200;
	}
	
	/**
	 * 删除好友
	 * @param username 用户名,friendname 好友名
	 * @return 是否删除成功：true成功 false失败
	 */
	public boolean deleteFriend(String username, String friendname) {
		EmchatRestResult result = RestDelete("users/" + username + "/contacts/users/" + friendname);
		return result.getCode()==200;
	}
	
	/**
	 * 查询好友列表
	 * @param username 用户名
	 * @return
	 */
	public List queryFriend(String username) {
		List list = null;
		EmchatRestResult result = RestGet("users/" + username + "/contacts/users");
		if(result.getCode()==200) {
			list = (List)result.getMessageMap().get("data");
		}
		return list;
	}
	
	/**
	 * 查询用户是否在线
	 * @param friendname 好友名
	 * @return 是否在线：1在线 0离线
	 */
	public int queryFriendStatus(String friendname) {
		int returnValue = 0;
		EmchatRestResult result = RestGet("users/" + friendname + "/status");
		if(result.getCode()==200) {
			Map data = (Map)result.getMessageMap().get("data");
			String stliu = (String)data.get(friendname);
			if("online".equals(stliu)) {
				returnValue = 1;
			}
		}
		return returnValue;
	}
	
	/**
	 * 发送消息
	 * @param username 发送人用户名
	 * @param friendname 接收人的username或者接收group的ID
	 * @param msg 信息内容
	 * @return 是否发送成功：true成功 false失败
	 */
	public boolean createUserMessage(String username, String friendname, String msg) {
		String post = "{\"target_type\":\"users\",\"target\":[\"" + friendname + "\"],\"msg\":{\"type\":\"txt\",\"msg\":\"" + msg + "\"},\"from\":\"" + username + "\"}";
		EmchatRestResult result = RestPost("messages", post);
		return result.getCode()==200;
	}
	
	/**
	 * 接收消息，该接口每分钟只允许调用10次
	 * @param date 某个时间后的消息
	 * @return msg_id 消息编号
	 * 		   type txt为文本消息（暂时只支持文本消息）
	 * 		   chat_type chat: 单聊；groupchat: 群聊
	 * 		   timestamp 消息发送时间
	 * 		   from 消息发送人
	 * 		   to 消息接收人
	 *         msg 消息内容
	 */
	public List queryUserMessage(Date date) {
		List list = null;
		try {
			Timestamp ts = new Timestamp(date.getTime());
			EmchatRestResult result = RestGet("chatmessages?ql=" + URLEncoder.encode("select * where timestamp>" + ts.getTime(),"utf-8"));
			if(result.getCode()==200) {
				List entities = (List)result.getMessageMap().get("entities");
				
				if(entities.size()>0) {
					list = new ArrayList();
					for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
						Map map = (Map) iterator.next();
						
						List boides = (ArrayList)((Map)map.get("payload")).get("bodies");
						Map boide = (Map)boides.get(0);
						
						if("txt".equals(String.valueOf(boide.get("type")))) {
							
							Map data = new HashMap();
							data.put("msg_id", map.get("msg_id"));
							data.put("type", map.get("type"));
							data.put("chat_type", map.get("chat_type"));
							data.put("timestamp", map.get("timestamp"));
							data.put("from", map.get("from"));
							data.put("to", map.get("to"));
							data.put("msg", boide.get("msg"));
							list.add(data);
						}
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	/**
	 * 创建群组
	 * @param groupname 群组名,owner 管理员
	 * @return groupid 群组id
	 */
	public String createGroup(String groupname, String owner) {
		String returnValue = "";
		String post = "{\"groupname\":\"" + groupname + "\",\"desc\":\"" + groupname + "\",\"public\":true,\"maxusers\":\"500\",\"approval\":false,\"owner\":\"" + owner + "\"}";
		EmchatRestResult result = RestPost("chatgroups", post);
		if(result.getCode()==200) {
			Map data = (Map)result.getMessageMap().get("data");
			if(data != null) {
				//Map map = (HashMap)data.get(0);
				returnValue = (String)data.get("groupid");
			}
		}
		return returnValue;
	}
	
	/**
	 * 删除群组
	 * @param groupname 群组名
	 * @return 是否删除成功：true成功 false失败
	 */
	public boolean deleteGroup(String groupname) {
		EmchatRestResult result = RestDelete("chatgroups/" + groupname);
		return result.getCode()==200;
	}
	
	/**
	 * 查询指定用户的所有群组
	 * @param username 用户名
	 * @return 群组列表：groupid 群组编号, groupname 群组名称
	 */
	public List queryGroupsByUser(String username) {
		List list = null;
		EmchatRestResult result = RestGet("users/" + username + "/joined_chatgroups");
		if(result.getCode()==200) {
			list = (List)result.getMessageMap().get("data");
		}
		return list;
	}
	
	/**
	 * 查询指定群组的所有用户
	 * @param groupid 群组编号
	 * @return username 用户名 usertype 用户类型 1管理员 2用户
	 */
	public List queryGroupMembers(String groupid) {
		List list = null;
		EmchatRestResult result = RestGet("chatgroups/" + groupid + "/users/");
		if(result.getCode()==200) {
			List data = (List)result.getMessageMap().get("data");
			list = new ArrayList();
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				Map map = (Map) iterator.next();
				if(map.containsKey("owner")) {
					Map item = new HashMap();
					item.put("username", map.get("owner"));
					item.put("usertype", "1");
					list.add(item);
				} else if(map.containsKey("member")) {
					Map item = new HashMap();
					item.put("username", map.get("member"));
					item.put("usertype", "2");
					list.add(item);
				}
			}
		}
		return list;
	}
	
	/**
	 * 添加群组成员
	 * @param groupid 群组编号
	 * @param username 用户名
	 * @return 是否添加成功：true成功 false失败
	 */
	public boolean createGroupMember(String groupid, String username) {
		EmchatRestResult result = RestPost("chatgroups/" + groupid + "/users/" + username, null);
		return result.getCode()==200;
	}
	
	/**
	 * 删除群组成员
	 * @param groupid
	 * @param username
	 * @return 是否添加成功：true成功 false失败
	 */
	public boolean deleteGroupMember(String groupid, String username) {
		EmchatRestResult result = RestDelete("chatgroups/" + groupid + "/users/" + username);
		return result.getCode()==200;
	}
	
	/**
	 * 删除群组
	 * @param groupid
	 * @return 是否删除成功：true成功 false失败
	 */
	public boolean deleteGroup(String groupid, String username) {
		EmchatRestResult result = RestDelete("chatgroups/" + groupid);
		return result.getCode()==200;
	}
	
}
