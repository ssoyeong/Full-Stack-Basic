package com.example.guestbook.controller;

import com.example.guestbook.dto.Guestbook;
import com.example.guestbook.service.GuestbookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {

    @Autowired
    GuestbookService guestbookService;

    @GetMapping     // path는 @RequestMapping을 통해 공통으로 주어짐
    // ContentType이 applicaiton/json으로 요청이 들어옴
    // DispatcherServlet는 JSON MessageConverter를 내부적으로 사용하여 해당 Map 객체를 JSON으로 변환해서 전송함
    public Map<String, Object> list(@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

        List<Guestbook> list = guestbookService.getGuestbooks(start);

        int count = guestbookService.getCount();
        int pageCount = count / GuestbookService.LIMIT;
        if(count % GuestbookService.LIMIT > 0) pageCount++;

        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * GuestbookService.LIMIT);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("count", count);
        map.put("pageStartList", pageStartList);

        return map;
    }

    @PostMapping
    // Guestbook 객체도 JSON 메소드로 변환되어 클라이언트에게 전달됨
    public Guestbook write(@RequestBody Guestbook guestbook, HttpServletRequest request) {

        String clientIp = request.getRemoteAddr();

        Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
        return resultGuestbook;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable(name = "id") Long id, HttpServletRequest request) {

        String clientIp = request.getRemoteAddr();

        int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
        return Collections.singletonMap("success", deleteCount > 0 ? "true" : "flase");
    }
}
