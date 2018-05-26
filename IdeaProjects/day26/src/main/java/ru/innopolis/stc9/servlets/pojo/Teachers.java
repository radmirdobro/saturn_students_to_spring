package ru.innopolis.stc9.servlets.pojo;

public class Teachers {
    private int id;
    private String name;
    private String adres;
    private String phone;
    private String email;
    private int subject_id;
    private Subject subject;
    private String status;
    private int users_id;

    public Teachers(String name, String adres, String phone, String email, int subject_id, String status) {
        this.name = name;
        this.adres = adres;
        this.phone = phone;
        this.email = email;
        this.subject_id = subject_id;
        this.status = status;

    }

    public Teachers(int id, String name, String adres, String phone, String email, int subject_id, Subject subject, String status) {
        this.id = id;
        this.name = name;
        this.adres = adres;
        this.phone = phone;
        this.email = email;
        this.subject_id = subject_id;
        this.subject = subject;
        this.status = status;
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

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}

