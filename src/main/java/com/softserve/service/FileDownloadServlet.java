package com.softserve.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/FileDownload")
public class FileDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String filePath = req.getParameter("filePath");
        String fileType = req.getParameter("fileType");
        File targetFile = new File("storage/" + filePath);
        byte[] fileContent = Files.readAllBytes(targetFile.toPath());
        resp.getOutputStream().write(fileContent);
        resp.setContentType(fileType);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
