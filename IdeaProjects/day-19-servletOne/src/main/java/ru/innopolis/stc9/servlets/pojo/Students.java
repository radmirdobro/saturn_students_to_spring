package ru.innopolis.stc9.servlets.pojo;

import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;

public class Students {
    private int id;
    private String name;
    private int age;
    private String adres;
    private String phone;
    private String email;
    private String group;
    private int course;
    private int groups_id;
    private int users_id;


    public Students(){};

    public Students(String name, int age, String adres, String phone, String email, String group, int course) {
        this.name = name;
        this.age = age;
        this.adres = adres;
        this.phone = phone;
        this.email = email;
        this.group = group;
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroups_id() {
        return groups_id;
    }

    public void setGroups_id(int groups_id) {
        this.groups_id = groups_id;
    }

    public Students(int id, String name, int age, String adres, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adres = adres;
        this.phone = phone;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}


