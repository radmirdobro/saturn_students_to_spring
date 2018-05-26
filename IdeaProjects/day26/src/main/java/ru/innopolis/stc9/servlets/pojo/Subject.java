package ru.innopolis.stc9.servlets.pojo;

public class Subject {
    private int id;
    private String sname;
    private int duration;
    private int material_id;
    private int mark_summ;
    private int subj_counter;

    public Subject(int id, String sname, int mark_summ, int subj_counter) {
        this.id = id;
        this.sname = sname;
        this.mark_summ = mark_summ;
        this.subj_counter = subj_counter;
    }

    public int getSubj_counter() {
        return subj_counter;
    }

    public int getMark_summ() {
        return mark_summ;
    }

    public int getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public int getDuration() {
        return duration;
    }

    public int getMaterial_id() {
        return material_id;
    }
}
