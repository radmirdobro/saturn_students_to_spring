package ru.innopolis.stc9.servlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.servlets.db.dao.UsersDAO;
import ru.innopolis.stc9.servlets.db.dao.UsersDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.UserService;

public class Main {
    final static Logger loggerConsoleInf = Logger.getLogger("consoleinf");

    public static void main(String[] args) {
        StudentsDAOImpl st = new StudentsDAOImpl();
        Students student = new Students();

     /*
                  int b = 13;
            student =  st.getStudentbyUID(b);
        loggerConsoleInf.info(student.getName());
        loggerConsoleInf.info("getStudentbyUID end");
     */

      /*
         TimetableDAOImpl timetable = new TimetableDAOImpl();


        ArrayList<Timetable> subjects= timetable.getTimetableByStGID(1);
        for(int a=0; a<subjects.size(); a++){
            loggerConsoleInf.info(subjects.get(a).getSname());
    }

 */

       /* GroupsDAO groupsDAO = new GroupsDAOImpl();
        loggerConsoleInf.info(groupsDAO.getStGroupById(1));
        */

        /* MarksDAO mark = new MarksDAOImpl();
        SubjectDAO subjectDAO = new SubjectDAOImpl();


        ArrayList<Marks> marks = mark.getStMarkForSubject(10);
        ArrayList<Subject> sid = subjectDAO.getAllSubjects();
        for (int a = 0; a < sid.size(); a++) {
            loggerConsoleInf.info(sid.get(a).getMark_summ());
            for (int b = 0; b < marks.size(); b++) {
                if (sid.get(a).getId() == marks.get(b).getSubject_id()) {
                    Subject subj = new Subject(sid.get(a).getId(),
                            sid.get(a).getSname(),
                            sid.get(a).getMark_summ() + marks.get(b).getMark(),
                            sid.get(a).getSubj_counter()+1);
                    sid.set(a, subj);
                }
            }
        }

        for (int c = 0; c < sid.size(); c++) {
            loggerConsoleInf.info(sid.get(c).getSname() +": "+sid.get(c).getMark_summ()/sid.get(c).getSubj_counter());
        }

        TimetableDAO timetableDAO = new TimetableDAOImpl();
        int id = 3;
        Timetable hwInfo = timetableDAO.getLessonById(id);
        loggerConsoleInf.info(hwInfo.getHomework());

        SubjectDAO subjectDAO = new SubjectDAOImpl();
        int sid = 5;
        loggerConsoleInf.info("getSubjectNameById(5) started");
        String str = subjectDAO.getSubjectNameById(sid);
        loggerConsoleInf.info(str);

        HomeWorksDAO homeWorksService = new HomeWorksDAOImpl();
        HomeWorks hwanswer = new HomeWorks();
        int timetable_id = 4;
        int student_id = 10;
        loggerConsoleInf.info(homeWorksService.isHomeWorkEmpty(timetable_id, student_id));

        HomeWorks hw = new HomeWorks("decision 123", "file", timetable_id, student_id);

        if (homeWorksService.isHomeWorkEmpty(timetable_id, student_id) == false) {
            loggerConsoleInf.info("get answer");
            //homeWorksService.updateHomeWork(hw);
            hwanswer =homeWorksService.getHomeWorkAnswer(timetable_id, student_id);
            loggerConsoleInf.info( hwanswer.getDecision());
        } else {
            loggerConsoleInf.info("add");
            homeWorksService.addHomeWork(hw);
        }

        hw = null;
*/
        UserService userService = new UserService();
        UsersDAO userDao = new UsersDAOImpl();

        String oldPasswordHash = userDao.getUserPwd(13);
        //loggerConsoleInf.info(oldPasswordHash);
        // loggerConsoleInf.info(userService.checkOldPwd(oldPasswordHash, 13));


        userService.updatePwd("password", 13);

    }
}