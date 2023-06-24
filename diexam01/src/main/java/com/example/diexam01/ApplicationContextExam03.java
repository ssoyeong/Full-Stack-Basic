package com.example.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

    public static void main(String[] args) {
        // 설정 정보를 불러 읽어옴
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

//        Car car = (Car)ac.getBean("Car");
        Car car = (Car)ac.getBean(Car.class);
        car.run();
    }

}
