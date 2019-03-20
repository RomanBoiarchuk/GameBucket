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
import java.util.Set;

@WebServlet(name = "gamesView", urlPatterns = "/gamesView")
public class GamesViewServlet extends HttpServlet {
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
        GamesGetter gamesGetter = (GamesGetter) req.getAttribute("gamesGetter");
        Set<GameDto> gameDtos = converter.convert(gamesGetter.getGames(offset, limit));
        String urlPattern = (String)req.getAttribute("urlPattern");
        if (gameDtos.isEmpty()) {
            resp.sendRedirect(urlPattern + "?offset=" + (offset - limit)
                    + "&limit=" + limit);
        } else {
            req.setAttribute("gameDtos", gameDtos);
            req.getRequestDispatcher("WEB-INF/games.jsp?offset=" + offset
                    + "&limit=" + limit).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
