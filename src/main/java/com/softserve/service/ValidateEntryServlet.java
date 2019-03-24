package com.softserve.service;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "validateEntry", urlPatterns = "/validateEntry")
public class ValidateEntryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        password = UserService.encryptPassword(password);
        JSONObject result = new JSONObject();
        result.put("correct", UserService.authenticate(email, password));
        try {
            resp.getWriter().append(result.toString());
        } catch (JSONException ex) {
            resp.sendError(505);
        }
    }
}
