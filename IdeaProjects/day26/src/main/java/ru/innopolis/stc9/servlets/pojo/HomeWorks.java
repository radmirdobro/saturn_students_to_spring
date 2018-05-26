package ru.innopolis.stc9.servlets.pojo;

public class HomeWorks {
    private int id;
    private String decision;
    private String hwfile;
    private int student_id;
    private int timetable_id;

    public HomeWorks() {
    }

    ;

    public HomeWorks(String decision, String hwfile) {
        this.decision = decision;
        this.hwfile = hwfile;
    }

    ;

    public HomeWorks(int id, String decision, String hwfile, int student_id) {
        this.id = id;
        this.decision = decision;
        this.hwfile = hwfile;
        this.student_id = student_id;
    }

    public HomeWorks(String decision, String hwfile, int timetable_id, int student_id) {
        this.decision = decision;
        this.hwfile = hwfile;
        this.student_id = student_id;
        this.timetable_id = timetable_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getHwfile() {
        return hwfile;
    }

    public void setHwfile(String hwfile) {
        this.hwfile = hwfile;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTimetable_id() {
        return timetable_id;
    }

    public void setTimetable_id(int timetable_id) {
        this.timetable_id = timetable_id;
    }
}
