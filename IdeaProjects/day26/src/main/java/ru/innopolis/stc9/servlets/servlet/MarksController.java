package ru.innopolis.stc9.servlets.servlet;

import ru.innopolis.stc9.servlets.pojo.Marks;
import ru.innopolis.stc9.servlets.pojo.Subject;
import ru.innopolis.stc9.servlets.service.MarksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MarksController extends HttpServlet {
    static MarksService markService = new MarksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = ((Integer) req.getSession().getAttribute("uid"));
        int student_id = markService.getSIDbyUID(uid);
        ArrayList<Marks> marks = markService.getMarkForSubject(student_id);

        ArrayList<Subject> subjects = markService.getSubjects();
        markService.getSubjectsWithTotalMarks(subjects, marks);
        req.setAttribute("subjectsWithMarks", subjects);
        req.getRequestDispatcher("/marks.jsp").forward(req, resp);
    }
}
