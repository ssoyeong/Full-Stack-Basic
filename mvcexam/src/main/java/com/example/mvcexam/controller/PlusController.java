package com.example.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {

    @GetMapping("/plusform")
    public String plusform() {
        // 요청이 들어왔을 때, 해당 뷰의 이름만 알려주면 됨
        // ViewResolver가 이름에 파일의 경로를 붙여줄 거임
        return "plusForm";
    }

    @PostMapping("/plus")
    public String plus(@RequestParam(name = "value1", required = true) int value1,
                       @RequestParam(name = "value2", required = true) int value2,
                       ModelMap modelMap) {

        int result = value1 + value2;

        // HttpServletRequest, HttpServletResponse가 아닌 ModelMap에 넣어주면 Spring이 알아서 매핑해줌
        modelMap.addAttribute("value1", value1);
        modelMap.addAttribute("value2", value2);
        modelMap.addAttribute("result", result);

        return "plusResult";
    }
}
