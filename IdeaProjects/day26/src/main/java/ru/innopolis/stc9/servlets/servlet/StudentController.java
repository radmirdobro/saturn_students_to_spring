package ru.innopolis.stc9.servlets.servlet;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.StudentsService;
import ru.innopolis.stc9.servlets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController extends HttpServlet {
    static Students student = new Students();
    static UserService userService = new UserService();
    private static StudentsService studentsService = new StudentsService();
    final Logger loggerFileInf = Logger.getLogger("fileinf");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = ((int) req.getSession().getAttribute("uid"));
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = ((int) req.getSession().getAttribute("uid"));
        String newPassword = req.getParameter("newPassword");
        String oldPassword = req.getParameter("oldPassword");

        if (newPassword != null && oldPassword != null && userService.checkOldPwd(oldPassword, uid) == true) {
            userService.updatePwd(newPassword, uid);
            resp.sendRedirect(req.getContextPath() + "/inner/personal?succesMsg=done");
        } else {
            resp.sendRedirect(req.getContextPath() + "/inner/personal?errorMsg=emptyFields");
        }
    }
}
