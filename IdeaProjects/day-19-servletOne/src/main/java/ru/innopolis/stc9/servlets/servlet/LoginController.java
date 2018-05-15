package ru.innopolis.stc9.servlets.servlet;

import ru.innopolis.stc9.servlets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginController extends HttpServlet {
    static UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            req.getSession().invalidate();
        }
        req.setAttribute("message", "Здравствуйте! Авторизуйтесь, пожалуйста.");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");


        if (userService.checkAuth(login, password)) {
            Integer role = userService.getRole(login);
            Integer userId = userService.getId(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("uid", userId);
            req.getSession().setAttribute("role",role);
            resp.sendRedirect(req.getContextPath() + "/inner/dashboard");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authErr");
        }
    }
}
