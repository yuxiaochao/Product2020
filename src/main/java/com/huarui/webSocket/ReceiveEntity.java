package com.huarui.webSocket;

public class ReceiveEntity {

    private String sessionId;

    //发送人
    private String from;

    //接收人
    private String to;

    //当前通讯id
    private String groupId;

    //会话类型
    private GROUP_TYPE groupType;

    //消息文本
    private String msg;

    //消息类型
    private MSG_TYPE msgType;

    //会话类型
    private SESSION_TYPE sessionType;

    //发送时间
    private long sendTime;

    //转发时间
    private long forwardTime;

    //时间差值
    private long timeDifference;

    //原文件地址（当 MSG_TYPE === IMG，AD，VD）
    private String filePath;

    //压缩文件地址（当 MSG_TYPE === IMG，AD，VD）
    private String compressedFilePath;

    //文件大小 单位B （当 MSG_TYPE === IMG，AD，VD）
    private long fileSize;

    //媒体时长 单位s （当 MSG_TYPE === AD，VD）
    private long duration;

    enum GROUP_TYPE{
        PERMANENT,TEMPORARY
    }

    /**
     * TEXT 文本
     * IMG 图片
     * AD 语音
     * VD 视频
     * FILE 文件
     * VOC 语音通话
     * VIC 视频通话
     */
    enum MSG_TYPE{
        TEXT,IMG,AD,VD,FILE,VOC,VIC
    }

    /**
     * SINGLE_CHAT 单聊
     * GROUP_CHAT 群聊
     * SYSTEM_MSG 系统消息
     * HEART_MSG 心跳消息
     */
    enum SESSION_TYPE{
        SINGLE_CHAT,GROUP_CHAT,SYSTEM_MSG,HEART_MSG
    }


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public GROUP_TYPE getGroupType() {
        return groupType;
    }

    public void setGroupType(GROUP_TYPE groupType) {
        this.groupType = groupType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MSG_TYPE getMsgType() {
        return msgType;
    }

    public void setMsgType(MSG_TYPE msgType) {
        this.msgType = msgType;
    }

    public SESSION_TYPE getSessionType() {
        return sessionType;
    }

    public void setSessionType(SESSION_TYPE sessionType) {
        this.sessionType = sessionType;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public long getForwardTime() {
        return forwardTime;
    }

    public void setForwardTime(long forwardTime) {
        this.forwardTime = forwardTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCompressedFilePath() {
        return compressedFilePath;
    }

    public void setCompressedFilePath(String compressedFilePath) {
        this.compressedFilePath = compressedFilePath;
    }

    public long getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(long timeDifference) {
        this.timeDifference = timeDifference;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
