package com.example.diexam01;

public class Car {

    private Engine v8;

    public Car() {
        System.out.println("Car 생성자");
    }

    public void setEngine(Engine e) {
        this.v8 = e;
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
