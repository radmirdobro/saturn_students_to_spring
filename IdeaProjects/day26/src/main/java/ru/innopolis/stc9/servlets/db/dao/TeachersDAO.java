package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Teachers;

public interface TeachersDAO {
    public boolean checkForduplicate(Teachers teacher);

    public void addTeacher(Teachers teacher);

    public Teachers getTeacherbyId(int id);

    public void updateTeacher(Teachers teacher);

    public void deleteTeacherById(int id);
}
