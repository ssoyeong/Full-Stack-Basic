package com.example.guestbook.controller;

import com.example.guestbook.dto.Guestbook;
import com.example.guestbook.service.GuestbookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestbookController {

    @Autowired      // Service를 사용하기 위해 주입
    GuestbookService guestbookService;

    @GetMapping("/list")
    public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
                       ModelMap model) {

        // start로 시작하는 방명록 목록 구하기
        List<Guestbook> list = guestbookService.getGuestbooks(start);

        // 전체 페이지 수 구하기
        int count = guestbookService.getCount();
        int pageCount = count / GuestbookService.LIMIT;
        if(count % GuestbookService.LIMIT > 0) pageCount++;

        // 페이지 수만큼 start의 값을 리스트로 저장
        // 페이지 수가 3이라면, 0, 5, 10 저장
        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * GuestbookService.LIMIT);
        }

        model.addAttribute("list", list);
        model.addAttribute("count", count);
        model.addAttribute("pageStartList", pageStartList);

        return "list";      // list.jsp로 넘겨줌
    }

    @PostMapping("/write")
    public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
//        System.out.println("clientIp: " + clientIp);
        guestbookService.addGuestbook(guestbook, clientIp);
        return "redirect:list";
    }
}
