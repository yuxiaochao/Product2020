package com.huarui.product2020.service.impl;

import com.huarui.common.config.Global;
import com.huarui.common.utils.EasemobAPI;
import com.huarui.common.utils.ResponseHandler;
import com.huarui.common.utils.TokenUtil;
import com.huarui.product2020.service.SendMessageAPI;
import io.swagger.client.ApiException;
import io.swagger.client.api.MessagesApi;
import io.swagger.client.model.Msg;
import org.springframework.stereotype.Service;

@Service
public class EasemobSendMessage implements SendMessageAPI {
    private ResponseHandler responseHandler = new ResponseHandler();
    private MessagesApi api = new MessagesApi();
    @Override
    public Object sendMessage(final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameMessagesPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(), (Msg) payload);
            }
        });
    }
}
