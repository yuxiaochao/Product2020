package com.huarui.webSocket;

import com.alibaba.fastjson.JSON;
import com.huarui.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息服务类
 */
@Component
public class MessageService {

    @Autowired
    private RedisUtil _redisUtil;

    /**
     * 插入离线消息
     */
    public void setOfflineMessage(ReceiveEntity receiveEntity){
        String jsonString = JSON.toJSONString(receiveEntity);
        _redisUtil.lladd("msg_"+receiveEntity.getTo(),jsonString);
    }

    /**
     * 获取离线消息
     */
    public ReceiveEntity getOfflineMessage(String userId){
        if(_redisUtil.llength("msg_" + userId)>0){
            String jsonString = _redisUtil.lrpop("msg_" + userId).toString();
            if(jsonString==null||"".equals(jsonString)){
                return null;
            }
            return JSON.parseObject(jsonString, ReceiveEntity.class);
        }
        return null;
    }
}
