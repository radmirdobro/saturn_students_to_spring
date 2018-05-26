package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Students;

import java.util.ArrayList;

public interface StudentsDAO {
    public Students getStudentbyUID(int uid);

    int getStGIDByUID(int uid);

    int getStudentIDbyUID(int uid);

    public void addStudent(Students student);

    public void updateStudent(Students student);

    public void deleteStudentById(int id);

    public ArrayList<Students> getStudentList();
}
