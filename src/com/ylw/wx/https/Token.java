package com.ylw.wx.https;

import com.sun.istack.internal.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by 85243 on 2017/3/2.
 */
public class Token extends HttpServlet{
    Logger log = Logger.getLogger(Token.class);
    @Override
    public void init() throws ServletException {
        TokenThread.APPID = getInitParameter("appid");
        TokenThread.APPSECRET = getInitParameter("appsecret");
        log.info("appid :"+TokenThread.APPID);
        log.info("appsecret: " + TokenThread.APPSECRET);
        new Thread(new TokenThread()).start();
    }
}


