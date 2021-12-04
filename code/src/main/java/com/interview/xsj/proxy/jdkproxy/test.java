package com.interview.xsj.proxy.jdkproxy;

/**
 * @author xsj
 * @create 2021-03-18 15:59
 */
public class test {
    public static void main(String[] args) {
        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
