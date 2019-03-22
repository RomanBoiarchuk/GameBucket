package com.softserve.servlets;

import com.softserve.dao.PlayLaterDao;
import com.softserve.models.PlayLaterNote;
import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "playLaterToggle", urlPatterns = "/playLaterToggle")
public class PlayLaterToggleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        long gameId = Long.valueOf(req.getParameter("gameId"));
        PlayLaterDao dao = DataBaseUtilities.getPlayLaterDao();
        PlayLaterNote playLaterNote = new PlayLaterNote();
        playLaterNote.setUserId(user.getId());
        playLaterNote.setGameId(gameId);
        boolean exists = dao.exists(playLaterNote);
        if (exists) {
            dao.delete(playLaterNote);
            exists = false;
        } else {
            if (dao.add(playLaterNote)) {
                exists = true;
            }
        }
        JSONObject result = new JSONObject();
        result.put("on", exists);
        try {
            resp.getWriter().append(result.toString());
        } catch (JSONException e) {
            resp.sendError(505);
        }
    }
}
