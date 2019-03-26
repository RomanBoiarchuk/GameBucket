package com.softserve.controllers;

import com.softserve.dao.MarksDao;
import com.softserve.dao.PlayLaterDao;
import com.softserve.dto.Converter;
import com.softserve.dto.GameConverter;
import com.softserve.dto.GameDto;
import com.softserve.models.Game;
import com.softserve.models.Mark;
import com.softserve.models.PlayLaterNote;
import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "gamesView", urlPatterns = "/gamesView")
public class GamesViewServlet extends HttpServlet {
    private static final int DEFAULT_LIMIT = 5;
    private static final String DEFAULT_SEEK = "";
    private static final int DEFUALT_FROM_YEAR = 1958;
    private static final int DEFAULT_TO_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);
    private static Converter<Game, GameDto> converter =
            new GameConverter();

    private int tryParse(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private Map<GameDto, Boolean> playLaterNotesExist(Set<GameDto> gameDtos, User user) {
        Map<GameDto, Boolean> playLaterNotesExist = new HashMap<>();
        PlayLaterDao playLaterDao = DataBaseUtilities.getPlayLaterDao();
        for (GameDto gameDto : gameDtos) {
            if (user == null) {
                playLaterNotesExist.put(gameDto, false);
            } else {
                PlayLaterNote playLaterNote = new PlayLaterNote();
                playLaterNote.setUserId(user.getId());
                playLaterNote.setGameId(gameDto.getId());
                playLaterNotesExist.put(gameDto,
                        playLaterDao.exists(playLaterNote));
            }
        }
        return playLaterNotesExist;
    }

    private Map<GameDto, Integer> gamesMarks(Set<GameDto> gameDtos, User user) {
        Map<GameDto, Integer> gamesMarks = new HashMap<>();
        MarksDao marksDao = DataBaseUtilities.getMarksDao();
        for (GameDto gameDto : gameDtos) {
            if (user == null) {
                gamesMarks.put(gameDto, 0);
            } else {
                Mark mark = marksDao.getById(user.getId(), gameDto.getId());
                if (mark == null) {
                    gamesMarks.put(gameDto, 0);
                } else {
                    gamesMarks.put(gameDto, mark.getMark());
                }
            }
        }
        return gamesMarks;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int offset = tryParse(req.getParameter("offset"), 0);
        if (offset < 0) {
            offset = 0;
        }
        int limit = tryParse(req.getParameter("limit"), DEFAULT_LIMIT);
        String seek = (req.getParameter("seek") != null)
                ? req.getParameter("seek") : DEFAULT_SEEK;
        int fromYear = tryParse(req.getParameter("fromYear"), DEFUALT_FROM_YEAR);
        int toYear = tryParse(req.getParameter("toYear"), DEFAULT_TO_YEAR);
        GamesGetter gamesGetter = (GamesGetter) req.getAttribute("gamesGetter");
        Set<GameDto> gameDtos = converter.convert(gamesGetter.getGames(offset, limit,
                seek, fromYear, toYear));
        boolean nextPageExists = !gamesGetter.getGames(offset + limit, 1,
                seek, fromYear, toYear).isEmpty();
        User user = (User) req.getSession().getAttribute("user");
        Map<GameDto, Boolean> playLaterNotesExist = playLaterNotesExist(gameDtos, user);
        Map<GameDto, Integer> gamesMarks = gamesMarks(gameDtos, user);
        String urlPattern = (String) req.getAttribute("urlPattern");
        req.setAttribute("gameDtos", gameDtos);
        req.setAttribute("nextPageExists", nextPageExists);
        req.setAttribute("playLaterNotesExist", playLaterNotesExist);
        req.setAttribute("gamesMarks", gamesMarks);
        req.getRequestDispatcher("WEB-INF/games.jsp?offset=" + offset
                + "&limit=" + limit + "&seek=" + seek + "&fromYear="
                + fromYear + "&toYear=" + toYear).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
