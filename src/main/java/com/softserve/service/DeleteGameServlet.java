package com.softserve.service;

import com.softserve.dao.GamesDao;
import com.softserve.models.Game;
import com.softserve.models.User;
import com.softserve.models.UserRole;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "deleteGame", urlPatterns = "/deleteGame")
public class DeleteGameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
        } else if (user.getRole() == UserRole.ADMIN) {
            GamesDao dao = DataBaseUtilities.getGamesDao();
            long gameId = Long.valueOf(req.getParameter("gameId"));
            Game game = dao.getById(gameId);
            File image = new File("storage/gamesAvatars/" + game.getImg());
            image.delete();
            dao.deleteById(gameId);
            String beforeEdit = req.getParameter("previous");
            resp.sendRedirect(beforeEdit);
        } else {
            resp.sendRedirect("/games");
        }
    }
}
