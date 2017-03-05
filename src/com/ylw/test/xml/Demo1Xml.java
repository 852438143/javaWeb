package com.ylw.test.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by 85243 on 2017/3/3.
 */
public class Demo1Xml {
    public static void main(String[] args) {
        //Object -> xml
        EntityDemo ed = new EntityDemo("toUser","fromUser",12345678,"text");
        StringWriter sw = new StringWriter();
        try {

            JAXBContext context = JAXBContext.newInstance(EntityDemo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(ed,sw);
            //后面的两个replaceAll是为了吧&lt;转化为<
            System.out.println(sw.toString().replaceAll("&lt;",'<'+"").replaceAll("&gt;",'>'+""));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //xml -> Object
        //发现一个奇怪现象，就是toUser无论加不加<![CDATA[]]结果都是对的，这就很尴尬了
        //<![CDATA[]]>是对字符的保护，防止文本被解析，上面那个&lt;就是<被解析了
        // 继续熟悉jaxb到时候在深入分析
        StringReader xmlStr = new StringReader("<xml>\n" +
                "<ToUserName>toUser</ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>12345678</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[你好]]></Content>\n" +
                "</xml>");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EntityDemo.class);
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
            EntityDemo entityDemo = (EntityDemo) unMarshaller.unmarshal(xmlStr);
            System.out.println(entityDemo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }
}
