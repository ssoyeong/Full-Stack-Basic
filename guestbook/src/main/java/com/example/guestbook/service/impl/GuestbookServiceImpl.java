package com.example.guestbook.service.impl;

import com.example.guestbook.dao.GuestbookDao;
import com.example.guestbook.dao.LogDao;
import com.example.guestbook.dto.Guestbook;
import com.example.guestbook.dto.Log;
import com.example.guestbook.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GuestbookServiceImpl implements GuestbookService {

    @Autowired      // 알아서 GuestbookDao를 생성해서 주입해줌
    GuestbookDao guestbookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional      // 읽기만 하는 메소드인 경우 트랜잭션을 위해 사용 readOnly == true
    public List<Guestbook> getGuestbooks(Integer start) {
        List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGuestbook(Long id, String ip) {
        int deletedCount = guestbookDao.deleteById(id);
        Log log = new Log();
        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDao.insert(log);

        return deletedCount;
    }

    @Override
    @Transactional(readOnly = false)
    public Guestbook addGuestbook(Guestbook guestbook, String ip) {
        guestbook.setRegdate(new Date());
        Long insertedId = guestbookDao.insert(guestbook);       // insert해서 자동으로 만들어진 id 값을 얻어옴
        guestbook.setId(insertedId);

        Log log = new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);

        return guestbook;
    }

    @Override
    public int getCount() {
        return guestbookDao.selectCount();
    }
}
