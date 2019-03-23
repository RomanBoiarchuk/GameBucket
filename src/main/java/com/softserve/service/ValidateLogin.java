package com.softserve.service;

import com.softserve.models.User;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "validateLogin", urlPatterns = "/validateLogin")
public class ValidateLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        boolean loginned = (user == null) ? false : true;
        JSONObject result = new JSONObject();
        result.put("loginned", loginned);
        try {
            resp.getWriter().append(result.toString());
        } catch (JSONException ex) {
            resp.sendError(505);
        }

    }
}
