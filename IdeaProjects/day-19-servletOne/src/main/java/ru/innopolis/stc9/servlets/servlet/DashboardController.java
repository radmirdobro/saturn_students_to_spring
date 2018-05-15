package ru.innopolis.stc9.servlets.servlet;

import ru.innopolis.stc9.servlets.pojo.Timetable;
import ru.innopolis.stc9.servlets.service.GroupsService;
import ru.innopolis.stc9.servlets.service.TimetableService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DashboardController extends HttpServlet {
    private static TimetableService timetableService = new TimetableService();
    private static GroupsService groupsService = new GroupsService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = ((Integer)req.getSession().getAttribute("uid"));
        int gid = timetableService.getGroupIdByUID(uid);
        String gname = groupsService.getGroupById(gid);
        req.setAttribute("gname", gname);
        ArrayList<Timetable> subjects = timetableService.getTimetableByGID(gid);
       req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
