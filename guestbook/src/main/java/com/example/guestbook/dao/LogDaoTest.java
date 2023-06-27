package com.example.guestbook.dao;

import com.example.guestbook.config.ApplicationConfig;
import com.example.guestbook.dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class LogDaoTest {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        LogDao logDao = ac.getBean(LogDao.class);

        Log log = new Log();
        log.setIp("127.0.0.1");
        log.setMethod("insert");
        log.setRegdate(new Date());
        Long id = logDao.insert(log);
        System.out.println("id: " + id);

    }
}
