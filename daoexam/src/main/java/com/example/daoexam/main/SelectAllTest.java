package com.example.daoexam.main;

import com.example.daoexam.config.ApplicationConfig;
import com.example.daoexam.dao.RoleDao;
import com.example.daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SelectAllTest {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = ac.getBean(RoleDao.class);

        List<Role> list = roleDao.selectAll();
        for(Role role : list) {
            System.out.println(role);
        }

    }
}
