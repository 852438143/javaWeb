package com.ylw.test.enumDemo;

import com.ylw.wx.message.Message;

import java.util.Date;

/**
 * 一个方法不new可以通过set方法构造吗
 * 事实证明不可以
 * Created by 85243 on 2017/3/4.
 */
public class Test1 {
    public static void main(String[] args) {
        Message message  = null;
        message.setCreateTime((int) new Date().getTime());
        System.out.println(message);
    }
}
