package com.interview.xsj.proxy.staticproxy;

/**
 * @author xsj
 * @create 2021-04-02 11:34
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println(message);
        return message;
    }
}
