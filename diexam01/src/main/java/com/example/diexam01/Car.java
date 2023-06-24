package com.example.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired      // Car 객체 내 Engine 객체를 알아서 주입해줘. 이제 setter는 없어도 됨
    private Engine v8;

    public Car() {
        System.out.println("Car 생성자");
    }

    public void run() {
        System.out.println("엔진을 이용하여 자동차 달림");
        v8.exec();
    }

    public static void main(String[] args) {
        // 제어의 역전으로, Spring IoC 컨테이너가 아래와 같은 일들을 수행함
//        Engine e = new Engine();
//        Car c = new Car();
//        c.setEngine(e);
//        c.run();
    }
}
