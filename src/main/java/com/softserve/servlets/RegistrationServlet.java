package com.softserve.servlets;

import com.softserve.models.User;
import com.softserve.service.UserService;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("WEB-INF/registration.jsp").forward(req, resp);
        } else {
            resp.getWriter().print("<h2>Hello, " + user.getNickname() + "!</h2>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User();
        user.setEmail(req.getParameter("email").toLowerCase());
        user.setNickname(req.getParameter("nickname"));
        String password = req.getParameter("password");
        user.setPassword(UserService.encryptPassword(password));
        HttpSession session = req.getSession();
        if (DataBaseUtilities.getUsersDao().add(user)) {
            session.setAttribute("user", user);
        } else {
            resp.getWriter().print("<h2>Registration failed! Try later!</h2>");
        }
    }
}
