package com.ylw.test.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by 85243 on 2017/3/4.
 */
@XmlSeeAlso(EntitySubDemo.class)
@XmlRootElement(name="xml")
@XmlType(propOrder = {"toUserName","fromUserName","createTime","msgType"})
public class EntityDemo {
    private String toUserName;
    private String fromUserName;
    private int createTime;
    private String msgType;

    public EntityDemo(String toUserName, String fromUserName, int createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }

    public EntityDemo() {
    }
    //换名字 把toUserName -> ToUserName
    @XmlElement(name="ToUserName")
    public String getToUserName() {
        //重构使支付加上前缀
        return "<![CDATA["+toUserName+"]]>";
    }
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    @XmlElement(name="FromUserName")
    public String getFromUserName() {
        return "<![CDATA["+fromUserName+"]]>";
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
        return "<![CDATA["+msgType+"]]>";
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return "EntityDemo{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
