package com.ylw.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 85243 on 2017/3/3.
 */
public class RegularExpressions {
    public static void main(String[] args) {
        String str ="{\"access_token\":\"OBNUnc5LN-JVSj5c7YDc88LoIrKaih4z_IKLDtrevJiEeYX5pmAUqJUY-qqzqZEzZzCRw_PH2oBs2teBRWJ_-LtQOnxQ742SbkVCBwwcPPPz6xMGALnq3eEZKJQI7M58JREiADAAIV\",\"expires_in\":7200}";

        //正则表达式中{需要用[]括起来，还有最后一个分组要多加一个括号，不知道为什么啦！
        String patternStr = "[{]\"([^\"]+)\":([^,]+),\"([^\"]+)\":(([^}]+))[}]";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        System.out.println(matcher.groupCount());
        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
        /*String result = matcher.group(2);
        System.out.println(result.replaceAll("\"",""));
        System.out.println(result);
*/
    }
}
