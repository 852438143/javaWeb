package com.ylw.wx;

import com.sun.istack.internal.logging.Logger;
import com.ylw.wx.com.ylw.wx.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 85243 on 2017/2/28.
 */
public class Verification extends HttpServlet {
    static Logger log = Logger.getLogger(Verification.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        log.info("signature:" + signature + " timestamp:" + timestamp + " nonce:" + nonce + " echostr:" + echostr);
        ArrayList<String> list = new ArrayList<>();
        list.add(nonce);
        list.add(timestamp);
        list.add(Util.token);
        Collections.sort(list);
        log.info("aftersort" + list.get(0) + list.get(1) + list.get(2));

    }
}
