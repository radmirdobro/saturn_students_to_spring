package ru.innopolis.stc9.servlets.servlet;

import ru.innopolis.stc9.servlets.pojo.HomeWorks;
import ru.innopolis.stc9.servlets.pojo.Timetable;
import ru.innopolis.stc9.servlets.service.HomeWorksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeWorksController extends HttpServlet {
    HomeWorksService homeWorksService = new HomeWorksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer timetable_id = Integer.valueOf(req.getParameter("lesson"));
        Integer sid = Integer.valueOf(req.getParameter("sid"));
        Timetable hwInfo = homeWorksService.getLesson(timetable_id);
        String sname = homeWorksService.getSnameById(sid);
        int uid = ((Integer) req.getSession().getAttribute("uid"));
        int student_id = homeWorksService.getStIDbyUID(uid);

        req.setAttribute("hwInfo", hwInfo);
        req.setAttribute("sname", sname);

        if (homeWorksService.isHWEmpty(timetable_id, student_id) == false) {
            HomeWorks hw = homeWorksService.getHWAnswer(timetable_id, student_id);
            req.setAttribute("answer", hw.getDecision());
            req.setAttribute("url", hw.getHwfile());
        } else {
            req.setAttribute("answer", "");
            req.setAttribute("url", "");

        }

        req.getRequestDispatcher("/homework.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer timetable_id = Integer.valueOf(req.getParameter("lesson"));
        Integer subject_id = Integer.valueOf(req.getParameter("sid"));
        String answer = req.getParameter("answer");
        String url = req.getParameter("url");
        int uid = ((Integer) req.getSession().getAttribute("uid"));
        int student_id = homeWorksService.getStIDbyUID(uid);

        if (answer != null) {

            HomeWorks hw = new HomeWorks(answer, url, timetable_id, student_id);
            if (homeWorksService.isHWEmpty(timetable_id, student_id) == false) {
                homeWorksService.updateHW(hw);
            } else {
                homeWorksService.addHW(hw);
            }
            hw = null;
            resp.sendRedirect(req.getContextPath() + "/inner/homework?lesson=" + timetable_id + "&sid="
                    + subject_id + "&succesMsg=done");
        } else {
            resp.sendRedirect(req.getContextPath() + "/inner/homework?lesson=" + timetable_id + "&sid="
                    + subject_id + "&errorMsg=emptyFields");
        }

    }
}
