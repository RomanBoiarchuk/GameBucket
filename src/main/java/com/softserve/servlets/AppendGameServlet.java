package com.softserve.servlets;

import com.softserve.dao.GamesDao;
import com.softserve.models.Game;
import com.softserve.models.User;
import com.softserve.models.UserRole;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "appendGame", urlPatterns = "/appendGame")
@MultipartConfig
public class AppendGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
        } else if (user.getRole().equals(UserRole.ADMIN)) {
            req.getRequestDispatcher("WEB-INF/appendGame.jsp")
                    .forward(req, resp);
        } else {
            resp.sendRedirect("/games");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Game game = new Game();
        game.setTitle(req.getParameter("title"));
        game.setReleaseYear(Integer.valueOf(req.getParameter("releaseYear")));
        game.setDescription(req.getParameter("description"));
        GamesDao dao = DataBaseUtilities.getGamesDao();
        dao.add(game);
        String fileDataName = "image";
        Part filePart = req.getPart(fileDataName);
        String targetFilePath = "/gamesAvatars/game" + game.getId();
        if (filePart.getSize() != 0) {
            req.setAttribute("fileDataName", fileDataName);
            req.setAttribute("targetFilePath", targetFilePath);
            req.getRequestDispatcher("/fileUpload").include(req, resp);
            game.setImg("game" + game.getId());
            dao.update(game);
        }
        resp.sendRedirect("/games");
    }
}
