package com.ylw.test;

import com.ylw.wx.https.TokenThread;

import java.util.logging.Logger;

/**
 * Created by 85243 on 2017/2/28.
 */
public class Test1 {
    static Logger log = Logger.getLogger(Test1.class.getName());

    public static void main(String[] args) {
        log.info("info11");
        log.warning("warning11");
        TokenThread.APPID = "wx03a5a328762bf67f";
        TokenThread.APPSECRET = "b2124f07a5d47ad34b59254018b9bb52";
        new Thread(new TokenThread()).start();
    }
}
