package ru.innopolis.stc9.servlets.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Students;

public class StudentsService {
    static StudentsDAOImpl studentsDao = new StudentsDAOImpl();

    public static Students getStbyUID(int uid) {
        return studentsDao.getStudentbyUID(uid);
    }
}
