package com.ylw.wx;

import com.sun.istack.internal.logging.Logger;
import com.ylw.wx.message.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * Created by 85243 on 2017/3/4.
 */
public class CoreService {
    static Logger log = Logger.getLogger(CoreService.class);
    public static String  deal(HttpServletRequest req){
        Message message = null;
        Message respMessage = new Message() ;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String temp = null;
            while((temp=br.readLine())!=null){
                sb.append(temp);
            }
            log.info("req string is : "+ sb.toString());
            message = MessageUtil.xml2object(sb.toString());
            log.info("the request message is : " + message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(message.getMsgType().compareToIgnoreCase(MessageType.TEXT.toString())==0){
            respMessage = new RespTextMessage(message.getFromUserName(),message.getToUserName(),(int)new Date().getTime(),MessageType.TEXT.name(),((ReqTextMessage) message).getContent());
        }
        else{
            respMessage = new RespTextMessage(message.getFromUserName(),message.getToUserName(),(int)new Date().getTime(),MessageType.TEXT.name(),"傻狗");
            log.info("default message :" + respMessage.toString());
        }
        log.info("response Message is : " + respMessage.toString());
        return MessageUtil.object2xml(respMessage);
    }


}
