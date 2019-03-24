package com.softserve.service;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="validateNickname", urlPatterns = "/validateNickname")
public class ValidateNicknameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        JSONObject result = new JSONObject();
        result.put("nicknameExists", UserService.existsNickname(nickname));
        try {
            resp.getWriter().append(result.toString());
        } catch (JSONException ex) {
            resp.sendError(505);
        }
    }
}
