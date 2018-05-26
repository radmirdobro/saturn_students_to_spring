package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Marks;

import java.util.ArrayList;

public interface MarksDAO {
    public void addMark(Marks mark);

    public Marks getStudentMarksbySubject(int student_id, int subject_id);

    public void updateMark(Marks mark);

    public ArrayList<Marks> getStMarkForSubject(int student_id);


}
