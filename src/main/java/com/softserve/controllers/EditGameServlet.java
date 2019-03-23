package com.softserve.controllers;

import com.softserve.dao.GamesDao;
import com.softserve.models.Game;
import com.softserve.models.User;
import com.softserve.models.UserRole;
import com.softserve.service.GameService;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "editGame", urlPatterns = "/editGame")
@MultipartConfig
public class EditGameServlet extends HttpServlet {
    private Game game;
    private String previousUrl;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        long gameId = Long.valueOf(req.getParameter("gameId"));
        previousUrl = req.getHeader("referer");
        req.setAttribute("previous", previousUrl);
        if (!GameService.gameExists(gameId)) {
            resp.sendRedirect("/games");
        } else {
            game = DataBaseUtilities.getGamesDao()
                    .getById(gameId);
            req.setAttribute("game", game);
        }
        if (user == null) {
            resp.sendRedirect("/login");
        } else if (user.getRole().equals(UserRole.ADMIN)) {
            req.getRequestDispatcher("WEB-INF/editGame.jsp")
                    .forward(req, resp);
        } else {
            resp.sendRedirect("/games");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        game.setTitle(req.getParameter("title"));
        game.setReleaseYear(Integer.valueOf(req.getParameter("releaseYear")));
        game.setDescription(req.getParameter("description"));
        GamesDao dao = DataBaseUtilities.getGamesDao();
        String fileDataName = "image";
        Part filePart = req.getPart(fileDataName);
        String targetFilePath = "/gamesAvatars/game" + game.getId();
        if (filePart.getSize() != 0) {
            req.setAttribute("fileDataName", fileDataName);
            req.setAttribute("targetFilePath", targetFilePath);
            req.getRequestDispatcher("/fileUpload").include(req, resp);
            game.setImg("game" + game.getId());
        }
        dao.update(game);
        resp.sendRedirect(previousUrl);
    }
}
