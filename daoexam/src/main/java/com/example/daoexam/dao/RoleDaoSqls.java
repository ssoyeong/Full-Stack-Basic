package com.example.daoexam.dao;

public class RoleDaoSqls {

    public static final String SELECT_ALL = "SELECT role_id, description FROM role ORDER BY role_id";
    public static final String UPDATE = "UPDATE role SET description = :description where role_id = :roleId";
}
