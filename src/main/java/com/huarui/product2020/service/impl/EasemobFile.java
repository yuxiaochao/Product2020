package com.huarui.product2020.service.impl;

import com.huarui.common.config.Global;
import com.huarui.common.utils.EasemobAPI;
import com.huarui.common.utils.ResponseHandler;
import com.huarui.common.utils.TokenUtil;
import com.huarui.product2020.service.FileAPI;
import io.swagger.client.ApiException;
import io.swagger.client.api.UploadAndDownloadFilesApi;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EasemobFile implements FileAPI {
    private ResponseHandler responseHandler = new ResponseHandler();
    private UploadAndDownloadFilesApi api = new UploadAndDownloadFilesApi();
    @Override
    //上传文件 
    public Object uploadFile(final Object file) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatfilesPost(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),(File)file,true);
             }
        });
    }

    @Override
    //下载文件 
    public Object downloadFile(final String fileUUID, final String shareSecret, final Boolean isThumbnail) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
               return api.orgNameAppNameChatfilesUuidGet(Global.getConfig("ORG_NAME"), Global.getConfig("APP_NAME"), TokenUtil.getAccessToken(),fileUUID,shareSecret,isThumbnail);
            }
        });
    }
}
