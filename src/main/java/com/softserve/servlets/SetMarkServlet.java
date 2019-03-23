package com.softserve.servlets;

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

@WebServlet(name = "setMark", urlPatterns = "/setMark")
public class SetMarkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        int markInt = Integer.valueOf(req.getParameter("mark"));
        long gameId = Long.valueOf(req.getParameter("gameId"));
        if (markInt < 1 || markInt >  10) {
            return;
        }
        MarksDao marksDao = DataBaseUtilities.getMarksDao();
        Mark mark = new Mark();
        mark.setUserId(user.getId());
        mark.setGameId(gameId);
        mark.setMark(markInt);
        if (marksDao.exists(user.getId(), gameId)) {
            marksDao.update(mark);
        } else {
            marksDao.add(mark);
        }
    }
}
