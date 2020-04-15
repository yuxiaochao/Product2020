package com.huarui.product2020.service.impl;

import com.huarui.common.config.Global;
import com.huarui.common.utils.EasemobAPI;
import com.huarui.common.utils.ResponseHandler;
import com.huarui.common.utils.TokenUtil;
import com.huarui.product2020.service.ChatGroupAPI;
import io.swagger.client.ApiException;
import io.swagger.client.StringUtil;
import io.swagger.client.api.GroupsApi;
import io.swagger.client.model.*;
import org.springframework.stereotype.Service;

@Service
public class EasemobChatGroup implements ChatGroupAPI {

    private ResponseHandler responseHandler = new ResponseHandler();
    private GroupsApi api = new GroupsApi();
    @Override
    //获取群组，参数为空时获取所有群组 
    public Object getChatGroups(final Long limit, final String cursor) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),limit+"",cursor);
            }
        });
    }

    @Override
    //获取一个或者多个群组的详情 
    public Object getChatGroupDetails(final String[] groupIds) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdsGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),StringUtil.join(groupIds,","));
            }
        });
    }
    @Override
    //创建一个群组 
    public Object createChatGroup(final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(), (Group) payload);
            }
        });
    }

    @Override
    //修改群组信息 
    public Object modifyChatGroup(final String groupId, final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdPut(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId, (ModifyGroup) payload);
            }
        });
    }

    @Override
    //删除群组 
    public Object deleteChatGroup(final String groupId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId);
            }
        });
    }

    @Override
    //获取群组所有用户 
    public Object getChatGroupUsers(final String groupId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdUsersGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId);
            }
        });
    }

    @Override
    //群组加人[单个] 
    public Object addSingleUserToChatGroup(final String groupId, final String userId) {
        final UserNames userNames = new UserNames();
        UserName userList = new UserName();
        userList.add(userId);
        userNames.usernames(userList);
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdUsersPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId,userNames);
            }
        });
    }

    @Override
    //群组加人[批量] 
    public Object addBatchUsersToChatGroup(final String groupId, final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdUsersPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId, (UserNames) payload);
            }
        });
    }

    @Override
    //群组减人[单个] 
    public Object removeSingleUserFromChatGroup(final String groupId, final String userId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdUsersUsernameDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId,userId);
            }
        });
    }

    @Override
    //群组减人[批量] 
    public Object removeBatchUsersFromChatGroup(final String groupId, final String[] userIds) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdUsersMembersDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId,StringUtil.join(userIds,","));
            }
        });
    }

    @Override
    //群组转让 
    public Object transferChatGroupOwner(final String groupId, final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupidPut(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId, (NewOwner) payload);
            }
        });
    }

    @Override
    //查询群组黑名单 
    public Object getChatGroupBlockUsers(final String groupId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdBlocksUsersGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId);
            }
        });
    }

    @Override
    //群组黑名单个添加 
    public Object addSingleBlockUserToChatGroup(final String groupId, final String userId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdBlocksUsersUsernamePost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId,userId);
            }
        });
    }

    @Override
    //群组黑名单批量添加 
    public Object addBatchBlockUsersToChatGroup(final String groupId, final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdBlocksUsersPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId, (UserNames) payload);
            }
        });
    }

    @Override
    //群组黑名单单个删除 
    public Object removeSingleBlockUserFromChatGroup(final String groupId, final String userId) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdBlocksUsersUsernameDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId,userId);
            }
        });
    }

    @Override
    //群组黑名单批量删除 
    public Object removeBatchBlockUsersFromChatGroup(final String groupId, final String[] userIds) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatgroupsGroupIdBlocksUsersUsernamesDelete(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),groupId,StringUtil.join(userIds,","));
            }
        });
    }
}
