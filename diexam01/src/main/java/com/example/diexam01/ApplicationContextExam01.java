package com.example.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

    public static void main(String[] args) {

        // 스프링 공장
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("초기화 완료");

        UserBean userBean = (UserBean)ac.getBean("userBean");
        userBean.setName("Jeon");
        System.out.println(userBean.getName());

        // 싱글톤 패턴 확인
        UserBean userBean2 = (UserBean)ac.getBean("userBean");
        System.out.println(userBean.getName());

    }
}
