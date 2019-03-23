package com.softserve.controllers;

import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "marks", urlPatterns = "/marks")
public class MarksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("gamesGetter", (GamesGetter)
                    (offset, limit, seek, fromYear, toYear) -> DataBaseUtilities
                            .getMarksDao().getGames(user.getId(),
                                    offset, limit, seek, fromYear, toYear));
            req.setAttribute("urlPattern", "/marks");
            req.getRequestDispatcher("/gamesView").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
