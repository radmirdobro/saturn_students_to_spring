package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.*;
import ru.innopolis.stc9.servlets.pojo.HomeWorks;
import ru.innopolis.stc9.servlets.pojo.Timetable;

public class HomeWorksService {
    public static HomeWorksDAO homeWork = new HomeWorksDAOImpl();
    public static TimetableDAO timetable = new TimetableDAOImpl();
    public static SubjectDAO subjectDAO = new SubjectDAOImpl();
    static StudentsDAOImpl studentsDao = new StudentsDAOImpl();

    public static int getStIDbyUID(int uid) {
        return studentsDao.getStudentIDbyUID(uid);
    }

    public String getSnameById(int sid) {
        return subjectDAO.getSubjectNameById(sid);
    }

    public Timetable getLesson(int timetable_id) {
        return timetable.getLessonById(timetable_id);
    }

    public HomeWorks getHWAnswer(int timetable_id, int student_id) {
        return homeWork.getHomeWorkAnswer(timetable_id, student_id);
    }

    public boolean isHWEmpty(int timetable_id, int student_id) {
        return homeWork.isHomeWorkEmpty(timetable_id, student_id);
    }

    public void updateHW(HomeWorks homework) {
        homeWork.updateHomeWork(homework);
    }

    public void addHW(HomeWorks homework) {
        homeWork.addHomeWork(homework);
    }
}


