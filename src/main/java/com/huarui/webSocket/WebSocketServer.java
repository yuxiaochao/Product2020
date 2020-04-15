package com.huarui.webSocket;

import com.alibaba.fastjson.JSON;
import com.huarui.common.SpringContextUtil;
import com.huarui.product2020.entity.HrswTChatmessage;
import com.huarui.product2020.service.IHrswTChatmessageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author yuxiaochao
 */
@ServerEndpoint("/imServer/{userId}")
@Component
public class WebSocketServer {
    private GroupPool groupPool;

    private MessageService messageService;

    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 接收userId
     */
    private String userId = "";
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        session.setMaxIdleTimeout(3600000);
        this.session = session;
        this.userId = userId;
        webSocketMap = WebSocketPool.getWebSocketMap();
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
        } else {
            webSocketMap.put(userId, this);
            //在线数加1
            addOnlineCount();
        }
        WebSocketPool.setWebSocketMap(webSocketMap);
        LOGGER.info("用户连接:" + userId + ",当前在线人数为:" + getOnlineCount());
        try {
            //用户连接 读取离线消息
            if (messageService == null) {
                try {
                    messageService = SpringContextUtil.getBean(MessageService.class);
                } catch (Exception e) {
                    LOGGER.info("----------7-------" + messageService);
                    e.printStackTrace();
                }
            }
            while (true) {
                ReceiveEntity offlineMessage = messageService.getOfflineMessage(this.userId);
                if (offlineMessage == null) {
                    break;
                }
                sendMessage(JSON.toJSONString(offlineMessage));
                System.out.println("离线消息：" + offlineMessage.getMsg());
            }

        } catch (IOException e) {
            LOGGER.error("用户:" + userId + ",网络异常!!!!!!");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws IOException {
        if (webSocketMap.containsKey(userId)) {
            if (StringUtils.isNotBlank("1070331325") && webSocketMap.containsKey("1070331325")) {
                webSocketMap.get("1070331325").sendMessage(userId+"离线");
            }
            webSocketMap.remove(userId);
            //从set中删除
            subOnlineCount();
        }
        LOGGER.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.info("----------0-------" + groupPool);
        if (groupPool == null) {
            try {
                groupPool = SpringContextUtil.getBean(GroupPool.class);
            } catch (Exception e) {
                LOGGER.info("-----------------" + groupPool);
                e.printStackTrace();
            }
        }
        LOGGER.info("----------2-------" + groupPool);
        LOGGER.info("----------3-------" + messageService);
        if (messageService == null) {
            try {
                messageService = SpringContextUtil.getBean(MessageService.class);
            } catch (Exception e) {
                LOGGER.info("----------4-------" + messageService);
                e.printStackTrace();
            }
        }
        LOGGER.info("----------5-------" + messageService);

        //消息保存到数据库、redis
        if (StringUtils.isNotBlank(message) && !"undefined".equals(message)) {
            try {
                //检测用户是否在webSocketMap内
                if (!webSocketMap.containsKey(userId)) {
                    webSocketMap.put(userId, this);
                    LOGGER.info("还真有异常删除连接池的" + userId);
                }
                //解析发送的报文
                LOGGER.info(message);
                ReceiveEntity receiveEntity = JSON.parseObject(message, ReceiveEntity.class);
                String groupId = receiveEntity.getGroupId();
                long time = new Date().getTime();
                //追加发送人(防止串改)
                receiveEntity.setFrom(this.userId);
                //追加转发时间
                receiveEntity.setForwardTime(time);
                //计算时间差值
                receiveEntity.setTimeDifference(time - receiveEntity.getSendTime());
                LOGGER.info(JSON.toJSONString(receiveEntity));
                //TODO 当为系统消息时
                if (receiveEntity.getSessionType() == ReceiveEntity.SESSION_TYPE.SYSTEM_MSG
                        || receiveEntity.getSessionType() == ReceiveEntity.SESSION_TYPE.HEART_MSG) {
                    if (StringUtils.isNotBlank(this.userId) && webSocketMap.containsKey(this.userId)) {
                        webSocketMap.get(this.userId).sendMessage(JSON.toJSONString(receiveEntity));
                        LOGGER.info("发送系统消息给当前用户：" + this.userId);
                    } else {
                        //否则不在这个服务器上，发送到mysql或者redis
                        LOGGER.error("请求的userId:" + this.userId + "不在该服务器上");
                    }
                } else {
                    //传送给对应toUserId用户的websocket
                    String to = receiveEntity.getTo();
                    if (StringUtils.isNotBlank(to) && webSocketMap.containsKey(to)) {
                        LOGGER.info("发送给： " + to);
                        webSocketMap.get(to).sendMessage(JSON.toJSONString(receiveEntity));
                    } else {
                        //否则不在这个服务器上，发送到redis离线消息
                        LOGGER.info("发送到redis离线消息：" + to);
                        messageService.setOfflineMessage(receiveEntity);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session session
     * @param error   error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        LOGGER.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    void setDataBase(ReceiveEntity receiveEntity) {
        IHrswTChatmessageService chatmessageService = SpringContextUtil.getBean(IHrswTChatmessageService.class);
        HrswTChatmessage msg = new HrswTChatmessage();
        msg.setChme001(receiveEntity.getSessionId());
        msg.setChme003(receiveEntity.getFrom());
        msg.setChme005(new Date());
        msg.setChme006(receiveEntity.getGroupId());
        msg.setChme008(receiveEntity.getMsg());
        msg.setChme009(13);
        msg.setChme010(receiveEntity.getGroupId());
        ReceiveEntity.SESSION_TYPE sessionType = receiveEntity.getSessionType();

        switch (sessionType) {
            case HEART_MSG:
                break;
            case SYSTEM_MSG:
                msg.setChme002(1);
                chatmessageService.insert(msg);
                break;
            case GROUP_CHAT:
                msg.setChme002(2);
                chatmessageService.insert(msg);
                break;
            case SINGLE_CHAT:
                msg.setChme002(3);
                chatmessageService.insert(msg);
                break;
            default:
                break;
        }
    }


    /**
     * 发送自定义消息
     */
    public static void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
        LOGGER.info("发送消息到:" + userId + "，报文:" + message);
        if (StringUtils.isNotBlank(userId) && webSocketMap.containsKey(userId)) {
            webSocketMap.get(userId).sendMessage(message);
        } else {
            LOGGER.error("用户" + userId + ",不在线！");
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }


}
