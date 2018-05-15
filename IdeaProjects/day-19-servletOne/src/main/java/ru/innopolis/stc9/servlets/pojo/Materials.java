package ru.innopolis.stc9.servlets.pojo;

public class Materials {
    private int id;
    private String mname;
    private String aurthor;

    public int getId() {
        return id;
    }

    public Materials(String mname, String aurthor) {
        this.mname = mname;
        this.aurthor = aurthor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getAurthor() {
        return aurthor;
    }

    public void setAurthor(String aurthor) {
        this.aurthor = aurthor;
    }
}
