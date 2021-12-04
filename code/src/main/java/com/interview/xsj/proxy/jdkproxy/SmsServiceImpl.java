package com.interview.xsj.proxy.jdkproxy;

/**2.实现发送短信的接口
 * @author xsj
 * @create 2021-03-18 15:48
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
