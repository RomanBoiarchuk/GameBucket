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

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        } else {
            resp.getWriter().print("<h2>Hello, " + user.getNickname() + "!</h2>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");
        String encryptedPassword = UserService.encryptPassword(password);
        boolean userExists = UserService.authenticate(email, encryptedPassword);
        if (userExists) {
            HttpSession session = req.getSession();
            User user = DataBaseUtilities.getUsersDao()
                    .getByEmail(email);
            session.setAttribute("user",user);
            resp.getWriter().print("<h2>User found!</h2>");
        } else {
            resp.getWriter().print("<h2>Email or password is incorrect!</h2>");
        }
    }
}
