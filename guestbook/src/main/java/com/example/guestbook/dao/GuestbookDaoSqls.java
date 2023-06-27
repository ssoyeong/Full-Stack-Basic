package com.example.guestbook.dao;

public class GuestbookDaoSqls {

    public static final String SELECT_PARCING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
    public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
    public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
}
