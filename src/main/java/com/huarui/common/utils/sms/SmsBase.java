package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.HttpException;
import com.huarui.common.utils.sms.httpclient.HttpResponse;
import com.huarui.common.utils.sms.httpclient.IHttpClient;

public class SmsBase {
	protected String accountId;
	protected String password;
	protected IHttpClient httpClient;
	
	/**
	 * SmsBase constructor
	 * 
	 * @param accountId
	 * @param password
	 * @param httpClient
	 */
	public SmsBase(String accountId, String password, IHttpClient httpClient) {
		this.accountId = accountId;
		this.password = password;
		this.httpClient = httpClient;
	}
	
	/**
	 * Handle http status error
	 * 
	 * @param response raw http response
	 * @return response  raw http response
	 * @throws HttpException http status exception
	 */
	public HttpResponse handleError(HttpResponse response) throws HttpException {
		if(response.statusCode < 200 || response.statusCode >= 300) {
			throw new HttpException(response.statusCode, response.reason);
		}
		return response;
	}
}
