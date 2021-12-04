package com.xsj.springpractice.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xsj
 * @create 2021-02-23 22:22
 */
@Component("myJavaBean")
public class MyJavaBean implements InitializingBean {

    private String desc;

    private String remark;

    public MyJavaBean() {
        System.out.println("MyJavaBean的构造函数被执行啦");
    }
    public String getDesc() {
        return desc;
    }

    @Value("原始的描述信息")
    public void setDesc(String desc) {
        System.out.println("调用setDesc方法");
        this.desc = desc;
    }
    public String getRemark() {
        return remark;
    }

    @Value("原始的备注信息")
    public void setRemark(String remark) {
        System.out.println("调用setRemark方法");
        this.remark = remark;
    }
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet方法");
        this.desc = "在初始化方法中修改之后的描述信息";
    }
    @PostConstruct
    public void initMethod() {
        System.out.println("调用initMethod方法");
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[描述：").append(desc);
        builder.append("， 备注：").append(remark).append("]");
        return builder.toString();
    }

}
