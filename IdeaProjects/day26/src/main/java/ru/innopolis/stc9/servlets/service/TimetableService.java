package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.servlets.db.dao.TimetableDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Timetable;

import java.util.ArrayList;

public class TimetableService {
    static StudentsDAOImpl studentsDao = new StudentsDAOImpl();
    static TimetableDAOImpl timetableDAO = new TimetableDAOImpl();

    public static int getGroupIdByUID(int uid) {
        return studentsDao.getStGIDByUID(uid);
    }

    public static ArrayList<Timetable> getTimetableByGID(int gid) {
        return timetableDAO.getTimetableByStGID(gid);
    }
}
