package com.huarui.product2020.service.impl;

import com.huarui.common.config.Global;
import com.huarui.common.utils.EasemobAPI;
import com.huarui.common.utils.ResponseHandler;
import com.huarui.common.utils.TokenUtil;
import com.huarui.product2020.service.ChatMessageAPI;
import io.swagger.client.ApiException;
import io.swagger.client.api.ChatHistoryApi;
import org.springframework.stereotype.Service;

@Service
public class EasemobChatMessage  implements ChatMessageAPI {

    private ResponseHandler responseHandler = new ResponseHandler();
    private ChatHistoryApi api = new ChatHistoryApi();

    @Override
    //导出聊天记录，默认返回10条 
    public Object exportChatMessages(final Long limit, final String cursor, final String query) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatmessagesGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),query,limit+"",cursor);
            }
        });
    }

    @Override
    //获取聊天记录下载链接 GET
    public Object exportChatMessages(final String timeStr) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatmessagesTimeGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),timeStr);
            }
        });
    }
}
