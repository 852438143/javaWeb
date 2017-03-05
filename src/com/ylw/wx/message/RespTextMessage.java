package com.ylw.wx.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 85243 on 2017/3/4.
 */
@XmlRootElement(name="xml")
public class RespTextMessage extends  Message{
    private String content;

    public RespTextMessage(String toUserName, String fromUserName, int createTime, String msgType, String content) {
        super(toUserName, fromUserName, createTime, msgType);
        this.content = content;
    }

    public RespTextMessage() {
        super();
    }

    @XmlElement(name="Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RespTextMessage{" +
                "content='" + content + '\'' +
                "} " + super.toString();
    }
}
