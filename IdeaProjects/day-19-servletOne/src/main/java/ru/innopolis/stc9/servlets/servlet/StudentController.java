package ru.innopolis.stc9.servlets.servlet;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.StudentsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController extends HttpServlet {
    private static StudentsService studentsService = new StudentsService();
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    static Students student = new Students();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = ((int)req.getSession().getAttribute("uid"));
        if (uid != 0) {
            resp.setCharacterEncoding("windows-1251");
            student = studentsService.getStbyUID(uid);
            req.setAttribute("studentName", student.getName());
            req.setAttribute("studentAge", student.getAge());
            req.setAttribute("studentAdres", student.getAdres());
            req.setAttribute("studentEmail", student.getEmail());
            req.setAttribute("studentPhone", student.getPhone());
            req.setAttribute("studentGroup", student.getGroup());
            req.setAttribute("studentCourse", student.getCourse());

            req.getRequestDispatcher("/personal.jsp").forward(req, resp);
        }
    }
}
