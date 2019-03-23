package com.softserve.service;

import com.softserve.dao.MarksDao;
import com.softserve.models.Mark;
import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteMark", urlPatterns = "/deleteMark")
public class DeleteMarkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        long gameId = Long.valueOf(req.getParameter("gameId"));
        MarksDao marksDao = DataBaseUtilities.getMarksDao();
        Mark mark = marksDao.getById(user.getId(),gameId);
        marksDao.delete(mark);
    }
}
