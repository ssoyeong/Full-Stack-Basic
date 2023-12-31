package com.example.guestbook.service;

import com.example.guestbook.dto.Guestbook;

import java.util.List;

public interface GuestbookService {

    public static final Integer LIMIT = 5;
    public List<Guestbook> getGuestbooks(Integer start);
    public int deleteGuestbook(Long id, String ip);
    public Guestbook addGuestbook(Guestbook guestbook, String ip);
    public int getCount();
}
