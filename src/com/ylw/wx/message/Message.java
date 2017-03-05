package com.ylw.wx.message;

import javax.xml.bind.annotation.*;

/**
 * 封装了消息基类
 * Created by 85243 on 2017/3/4.
 */
@XmlSeeAlso({RespTextMessage.class,ReqTextMessage.class})
@XmlRootElement(name="xml")
@XmlType(propOrder = {"toUserName","fromUserName","createTime","msgType"})
public class Message {
    private String toUserName;
    private String fromUserName;
    private int createTime;
    private String msgType;

    public Message(String toUserName, String fromUserName, int createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }

    public Message() {
    }
    //换名字 把toUserName -> ToUserName
    @XmlElement(name="ToUserName")
    public String getToUserName() {
        //重构使支付加上前缀
        return toUserName;
    }
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    @XmlElement(name="FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlElement(name="CreateTime")
    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }
    @XmlElement(name="MsgType")
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return "Message{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}