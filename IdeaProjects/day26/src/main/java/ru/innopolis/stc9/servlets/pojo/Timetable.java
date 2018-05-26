package ru.innopolis.stc9.servlets.pojo;

public class Timetable {
    private int id;
    private int subject_id;
    private String date;
    private String time;
    private int groups_id;
    private String homework;
    private String sname;


    public Timetable(String sname, int subject_id, String date, String time, String homework, int id) {

        this.sname = sname;
        this.subject_id = subject_id;
        this.date = date;
        this.time = time;
        this.homework = homework;
        this.id = id;
    }

    public Timetable(int id, int subject_id, String date, String time) {
        this.id = id;
        this.subject_id = subject_id;
        this.date = date;
        this.time = time;
    }

    public Timetable(String date, String homework) {
        this.date = date;
        this.homework = homework;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGroups_id() {
        return groups_id;
    }

    public void setGroups_id(int groups_id) {
        this.groups_id = groups_id;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
}
