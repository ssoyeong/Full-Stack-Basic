package com.example.guestbook.service.impl;

import com.example.guestbook.config.ApplicationConfig;
import com.example.guestbook.dto.Guestbook;
import com.example.guestbook.service.GuestbookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GuestbookServiceTest {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookService guestbookService = ac.getBean(GuestbookService.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("soyeong");
        guestbook.setContent("안녕하세용");

        Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
        System.out.println(result);

    }
}
