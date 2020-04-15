package com.huarui.product2020.service.impl;

import com.huarui.common.utils.TokenUtil;
import com.huarui.product2020.service.AuthTokenAPI;
import org.springframework.stereotype.Service;

@Service
public class EasemobAuthToken implements AuthTokenAPI{

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
