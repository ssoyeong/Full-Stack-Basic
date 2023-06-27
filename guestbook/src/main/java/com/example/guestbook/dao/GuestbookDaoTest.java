package com.example.guestbook.dao;

import com.example.guestbook.config.ApplicationConfig;
import com.example.guestbook.dto.Guestbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class GuestbookDaoTest {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("Jeon");
        guestbook.setContent("스프링 아자자");
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insert(guestbook);
        System.out.println("id: " + id);

    }
}
