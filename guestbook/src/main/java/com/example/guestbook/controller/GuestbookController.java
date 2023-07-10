package com.example.guestbook.controller;

import com.example.guestbook.dto.Guestbook;
import com.example.guestbook.service.GuestbookService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
                       ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        // 방문자 수 집계를 위한 쿠키 처리
        String value = null;
        boolean find = false;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if("count".equals(cookie.getName())) {
                    find = true;
                    value = cookie.getValue();
                    break;
                }
            }
        }

        if(!find) {
            value = "1";
        }
        else {
            try {
                int i = Integer.parseInt(value);
                value = Integer.toString(++i);
            } catch (Exception e) {
                value = "1";
            }
        }

        Cookie cookie = new Cookie("count", value);
        cookie.setMaxAge(60 * 60 * 24 * 365);       // 1년 유지
        cookie.setPath("/");        // 경로 이하에 모든 쿠키 적용
        response.addCookie(cookie);

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
        model.addAttribute("cookieCount", value);

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
