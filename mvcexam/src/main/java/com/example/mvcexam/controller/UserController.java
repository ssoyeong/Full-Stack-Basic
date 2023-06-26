package com.example.mvcexam.controller;

import com.example.mvcexam.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/userform")
    public String userform() {
        return "userForm";
    }

    @PostMapping("/regist")
    public String regit(@ModelAttribute User user) {    // 파라미터를 하나씩 받아오는 게 아니라, DTO를 통해 객체로 받아옴

        System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
        System.out.println(user);
        return "regist";
    }

}
