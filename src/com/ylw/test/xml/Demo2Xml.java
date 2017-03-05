package com.ylw.test.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by 85243 on 2017/3/4.
 */
public class Demo2Xml {
    public static void main(String[] args) {

        //Object -> xml
        EntitySubDemo ed = new EntitySubDemo("toUser","fromUser",12345678,"text","hello");
        StringWriter sw = new StringWriter();
        try {

            JAXBContext context = JAXBContext.newInstance(EntitySubDemo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(ed,sw);
            //后面的两个replaceAll是为了吧&lt;转化为<
            System.out.println(sw.toString().replaceAll("&lt;",'<'+"").replaceAll("&gt;",'>'+""));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        StringReader xmlStr = new StringReader("<xml>\n" +
                "<ToUserName>toUser</ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>12345678</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[你好]]></Content>\n" +
                "</xml>");
        try {
            JAXBContext jc = JAXBContext.newInstance(EntityDemo.class);
            //这个和XmlSeeAlso只用实现一个就好了，一种在父类的前面注释@XmlSeeAlso(EntitySubDemo.class)
            //或者直接吧类写在里面 JAXBContext.newInstance(EntityDemo.class,EntitySubDemo.class);
            Unmarshaller u = jc.createUnmarshaller();
            EntitySubDemo o = (EntitySubDemo) u.unmarshal(xmlStr);
            System.out.println("-----"+o.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
