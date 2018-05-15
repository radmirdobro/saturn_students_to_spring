package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Timetable;

import java.util.ArrayList;
import java.util.List;

public interface TimetableDAO {
    public Timetable getLessonById(int id);
    public ArrayList getTimetableByStGID(int gid);
}
