package com.ylw.wx.https;

import com.sun.istack.internal.logging.Logger;
import com.ylw.wx.Util;

/**
 * Created by 85243 on 2017/3/3.
 */

public class TokenThread implements Runnable {
    static Logger log = Logger.getLogger(TokenThread.class);
    public static String APPID;
    public static String APPSECRET;
    public static String ACCESS_TOKEN;

    public TokenThread() {
    }

    public TokenThread(String appid, String appsecret) {
        this.APPID = appid;
        this.APPSECRET = appsecret;
    }

    @Override
    public void run() {
        while (true) {
            ACCESS_TOKEN = Util.getAccessTokenByHttps(APPID, APPSECRET);
            if (ACCESS_TOKEN != null && !ACCESS_TOKEN.equals("")) {
                log.info("accessToken: " + ACCESS_TOKEN);
                try {
                    //没过两个小时获取一次；
                    Thread.currentThread().sleep(7000 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
