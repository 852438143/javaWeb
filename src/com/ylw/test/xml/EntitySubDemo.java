package com.ylw.test.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by 85243 on 2017/3/4.
 */
@XmlRootElement(name="xml")
@XmlType(propOrder = {"content"})
//@XmlAccessorOrder
public class EntitySubDemo extends EntityDemo{
    private String content;

    public EntitySubDemo(String toUserName, String fromUserName, int createTime, String msgType, String content) {
        super(toUserName, fromUserName, createTime, msgType);
        this.content = content;
    }

    public EntitySubDemo() {
    }

    @XmlElement(name="Content")
    public String getContent() {
        return "<![CDATA["+content+">>]";
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EntitySubDemo{" +
                "content='" + content + '\'' +
                "} " + super.toString();
    }
}
