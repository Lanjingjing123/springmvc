package com.csii.ljj.entity;

public class User {
    private String userName;
    private int age;
    private int id;
    private Address address;

    public User(String userName, int age, int id) {
        this.userName = userName;
        this.age = age;
        this.id = id;
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", address=" + address +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
