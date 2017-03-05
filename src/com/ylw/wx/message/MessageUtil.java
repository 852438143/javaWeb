package com.ylw.wx.message;

import com.sun.istack.internal.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by 85243 on 2017/3/4.
 */
public class MessageUtil {
    static Logger log = Logger.getLogger(Message.class);
    public static Message xml2object(String xmlStr){
        log.info("xmlStr is : " + xmlStr);
        if(xmlStr==null || xmlStr.equals("")){
            return null;
        }
        Message message =null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Message.class);
            Unmarshaller um = jc.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            log.info("StringReader is : "+ sr.toString());
            message = (Message) um.unmarshal(sr);
            log.info("after parser the object is : " + message);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return message;
    }
    public static String object2xml(Message message){
        log.info("message is :" + message);
        String result = null;
        try {
            StringWriter sw = new StringWriter();
            JAXBContext jc = JAXBContext.newInstance(Message.class);
            Marshaller ms = jc.createMarshaller();
            ms.marshal(message,sw);
            result = sw.toString().replaceAll("&lt;",'<'+"").replaceAll("&gt;",'>'+"");
            log.info("after parser "+ result);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
