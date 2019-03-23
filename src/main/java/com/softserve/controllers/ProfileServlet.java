package com.softserve.controllers;

import com.softserve.dto.Converter;
import com.softserve.dto.UserConverter;
import com.softserve.dto.UserDto;
import com.softserve.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private static Converter<User, UserDto>
            converter = new UserConverter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            UserDto userDto = converter.convert(user);
            req.setAttribute("userDto", userDto);
            req.getRequestDispatcher("WEB-INF/profile.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
