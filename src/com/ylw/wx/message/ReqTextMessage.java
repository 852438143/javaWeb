package com.ylw.wx.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 85243 on 2017/3/4.
 */
@XmlRootElement(name="xml")
public class ReqTextMessage extends Message{
    private String content;
    private long msgId;

    public ReqTextMessage(String toUserName, String fromUserName, int createTime, String msgType, String content, long msgId) {
        super(toUserName, fromUserName, createTime, msgType);
        this.content = content;
        this.msgId = msgId;
    }

    public ReqTextMessage() {
    }
    @XmlElement(name="Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @XmlElement(name="MsgId")
    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "ReqTextMessage{" +
                "content='" + content + '\'' +
                ", msgId=" + msgId +
                "} " + super.toString();
    }
}
