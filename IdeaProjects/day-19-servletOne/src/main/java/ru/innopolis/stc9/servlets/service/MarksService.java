package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.*;
import ru.innopolis.stc9.servlets.pojo.Marks;
import ru.innopolis.stc9.servlets.pojo.Subject;

import java.util.ArrayList;

public class MarksService {
    MarksDAO marksDAO = new MarksDAOImpl();
    StudentsDAO studentsDAO = new StudentsDAOImpl();
    SubjectDAO subjectDAO = new SubjectDAOImpl();

    public int getSIDbyUID(int uid) {
        return studentsDAO.getStudentIDbyUID(uid);
    }

    public ArrayList<Marks> getMarkForSubject(int student_id) {
        return marksDAO.getStMarkForSubject(student_id);
    }

    public ArrayList<Subject> getSubjects() {
        return subjectDAO.getAllSubjects();
    }


    public void getSubjectsWithTotalMarks(ArrayList<Subject> subjects, ArrayList<Marks> marks) {
        for (int a = 0; a < subjects.size(); a++) {
            for (int b = 0; b < marks.size(); b++) {
                if (subjects.get(a).getId() == marks.get(b).getSubject_id()) {
                    Subject subj = new Subject(subjects.get(a).getId(),
                            subjects.get(a).getSname(),
                            subjects.get(a).getMark_summ() + marks.get(b).getMark(),
                            subjects.get(a).getSubj_counter() + 1);
                    subjects.set(a, subj);
                }
            }
        }
    }
}
