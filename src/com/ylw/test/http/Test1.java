package com.ylw.test.http;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 访问证书安全的https协议网站
 * Created by 85243 on 2017/3/2.
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx03a5a328762bf67f&secret=b2124f07a5d47ad34b59254018b9bb52

            URL url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx03a5a328762bf67f&secret=b2124f07a5d47ad34b59254018b9bb52");
            try {
                HttpsURLConnection httpsUrlConn = (HttpsURLConnection) url.openConnection();
                httpsUrlConn.connect();
                InputStream in = httpsUrlConn.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader breader = new BufferedReader(inputStreamReader);
                String str ;
                str = breader.toString();
                System.out.println(str);
                while((str = breader.readLine())!=null){
                    System.out.println(str);
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
