package com.example.diexam01;

public class UserBean {

    /*
    * 일반적인 Java 클래스 == Bean 클래스
    * 기본 생성자를 갖고 있음
    * 필드는 private으로 선언함
    * getter, setter 메소드를 가짐
    */

    private String name;
    private int age;
    private boolean male;

    public UserBean() {}

    public UserBean(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
