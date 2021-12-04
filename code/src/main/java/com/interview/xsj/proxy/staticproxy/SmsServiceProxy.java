package com.interview.xsj.proxy.staticproxy;

/**
 * @author xsj
 * @create 2021-04-02 11:36
 */
public class SmsServiceProxy implements SmsService {
    private final SmsService smsService;

    public SmsServiceProxy(SmsService smsService){
        this.smsService=smsService;
    }
    @Override
    public String send(String message) {
        System.out.println("发短信前添加操作");
        smsService.send(message);
        System.out.println("发短信后添加操作");
        return message;
    }
}
