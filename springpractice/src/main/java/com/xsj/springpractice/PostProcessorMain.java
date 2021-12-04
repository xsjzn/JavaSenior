package com.xsj.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xsj
 * @create 2021-02-23 22:59
 */
@SpringBootApplication
public class PostProcessorMain {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("config/postprocessor.xml");
//        MyJavaBean bean = (MyJavaBean) context.getBean("myJavaBean");
//
//
//        System.out.println("===============下面输出结果============");
//        System.out.println("描述：" + bean.getDesc());
//        System.out.println("备注：" + bean.getRemark());
        SpringApplication.run(PostProcessorMain.class,args);

    }


//    @Test
//    public void test(){
////        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainScanConfig.class);
////        MyJavaBean myJavaBean = (MyJavaBean)applicationContext.getBean("myJavaBean");
//
//
//    }

}