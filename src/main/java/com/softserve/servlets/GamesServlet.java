package com.softserve.servlets;

import com.softserve.dto.Converter;
import com.softserve.dto.GameConverter;
import com.softserve.dto.GameDto;
import com.softserve.models.Game;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "games", urlPatterns = "/games")
public class GamesServlet extends HttpServlet {
    private static final int DEFAULT_LIMIT = 5;
    private static Converter<Game, GameDto> converter =
            new GameConverter();

    private int tryParse(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int offset = tryParse(req.getParameter("offset"), 0);
        int limit = tryParse(req.getParameter("limit"), DEFAULT_LIMIT);
        req.setAttribute("offset", offset);
        req.setAttribute("limit", limit);
        Set<GameDto> gameDtos = converter.convert(
                DataBaseUtilities.getGamesDao()
                        .getGames(offset, limit)
        );
        req.setAttribute("gameDtos", gameDtos);
        req.getRequestDispatcher("WEB-INF/games.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
