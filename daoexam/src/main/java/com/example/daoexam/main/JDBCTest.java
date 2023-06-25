package com.example.daoexam.main;

import com.example.daoexam.config.ApplicationConfig;
import com.example.daoexam.dao.RoleDao;
import com.example.daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTest {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = ac.getBean(RoleDao.class);

        Role role = new Role();
        role.setRoleId(300);
        role.setDescription("CEO");

        int count = roleDao.insert(role);
        System.out.println(count + " 입력했습니다.");

        role.setRoleId(500);
        role.setDescription("Programmer");
        count = roleDao.update(role);
        System.out.println(count + " 수정했습니다.");
    }
}
