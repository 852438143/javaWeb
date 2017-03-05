package com.ylw.wx;

import com.sun.istack.internal.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 85243 on 2017/2/28.
 */
public class Util {
    private static Logger log = Logger.getLogger(Util.class);
    final public static String token = "weixin";

    /**
     *
     * @param appid
     * @param appSecret
     * @return 返回token字符串
     */
    public static String getAccessTokenByHttps(String appid,String appSecret){
        StringBuilder sb = new StringBuilder("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");
        sb.append("&appid=");
        sb.append(appid);
        sb.append("&secret=");
        sb.append(appSecret);
        log.info("sb is :" + sb.toString());
        try {
            if(sb==null||sb.equals("")){
                return null;
            }
            URL url = new URL(sb.toString());
            log.info("url is :"  +url.toString());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.connect();
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader br = new BufferedReader( new InputStreamReader(inputStream));
            StringBuilder jsonStr  = new StringBuilder();
            String temp ;
            while((temp=br.readLine())!=null){
                jsonStr.append(temp);
            }
            log.info("jsonStr is : " + jsonStr.toString());
            String accessToken = takeRegularExpression(jsonStr.toString());
            return accessToken = accessToken.replaceAll("\"","");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param jsonStr
     * @return  把json数据格式经过正则表达式改变后获得的token字符串；
     */
    public static String takeRegularExpression(String jsonStr){
        String result = "";
        String patternStr  = "[{]\"([^\"]+)\":([^,]+),\"([^\"]+)\":(([^}]+))[}]";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher mattcher = pattern.matcher(jsonStr);
        List<String> list = new ArrayList<>();
        if(mattcher.find()){
            for(int i = 0;i<mattcher.groupCount();i++){
                list.add(mattcher.group(i));
                log.info("i = "+i+" list: "+list.get(i));
            }
        }
        result = list.get(2);
        return result.replaceAll("\"","");
    }
}
