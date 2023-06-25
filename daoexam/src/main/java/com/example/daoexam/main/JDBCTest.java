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

        // INSERT 및 UPDATE
//        Role role = new Role();
//        role.setRoleId(300);
//        role.setDescription("CEO");
//
//        int count = roleDao.insert(role);
//        System.out.println(count + " 입력했습니다.");
//
//        role.setRoleId(500);
//        role.setDescription("Programmer");
//        count = roleDao.update(role);
//        System.out.println(count + " 수정했습니다.");

        // SELECT 및 DELETE
        Role selectedRole = roleDao.selectById(500);
        System.out.println(selectedRole);

        int deletedCount = roleDao.deleteById(100);
        System.out.println(deletedCount + " 삭제했습니다.");

        Role selectedRole2 = roleDao.selectById(100);
        System.out.println(selectedRole2);

    }
}
