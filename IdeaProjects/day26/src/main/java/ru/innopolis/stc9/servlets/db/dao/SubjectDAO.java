package ru.innopolis.stc9.servlets.db.dao;

import java.util.ArrayList;

public interface SubjectDAO {
    public String getSubjectNameById(int sid);

    public ArrayList getAllSubjects();

}
