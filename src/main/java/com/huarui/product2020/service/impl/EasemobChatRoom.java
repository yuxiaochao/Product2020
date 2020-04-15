package com.huarui.product2020.service.impl;

import com.huarui.common.config.Global;
import com.huarui.common.utils.EasemobAPI;
import com.huarui.common.utils.ResponseHandler;
import com.huarui.common.utils.TokenUtil;
import com.huarui.product2020.service.ChatRoomAPI;
import io.swagger.client.ApiException;
import io.swagger.client.StringUtil;
import io.swagger.client.api.ChatRoomsApi;
import io.swagger.client.model.Chatroom;
import io.swagger.client.model.ModifyChatroom;
import io.swagger.client.model.UserNames;
import org.springframework.stereotype.Service;

@Service
public class EasemobChatRoom implements ChatRoomAPI {
    private ResponseHandler responseHandler = new ResponseHandler();
    private ChatRoomsApi api = new ChatRoomsApi();

    @Override
    //创建聊天室 
    public Object createChatRoom(final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(), (Chatroom) payload);
            }
        });
    }

    @Override
    //修改聊天室信息 
    public Object modifyChatRoom(final String roomId, final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdPut(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId, (ModifyChatroom) payload);
            }
        });
    }

    @Override
    //删除聊天室 
    public Object deleteChatRoom(final String roomId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId);
            }
        });
    }

    @Override
    //获取app中所有的聊天室 
    public Object getAllChatRooms() {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken());
            }
        });
    }

    @Override
    //获取一个聊天室详情 
    public Object getChatRoomDetail(final String roomId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId);
            }
        });
    }

    @Override
    //聊天室成员添加[单个] 
    public Object addSingleUserToChatRoom(final String roomId, final String userName) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersUsernamePost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId,userName);
            }
        });
    }

    @Override
    //聊天室成员添加[批量] 
    public Object addBatchUsersToChatRoom(final String roomId, final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId, (UserNames) payload);
            }
        });
    }

    @Override
    //聊天室成员删除[单个] 
    public Object removeSingleUserFromChatRoom(final String roomId, final String userName) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersUsernameDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId,userName);
            }
        });
    }

    @Override
    //聊天室成员删除[批量] 
    public Object removeBatchUsersFromChatRoom(final String roomId, final String[] userNames) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersUsernamesDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),roomId, StringUtil.join(userNames,","));
            }
        });
    }
}
