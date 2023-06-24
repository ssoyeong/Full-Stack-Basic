package com.example.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    public Engine() {
        System.out.println("Engine 생성자");
    }

    public void exec() {
        System.out.println("엔진 동작");
    }
}
