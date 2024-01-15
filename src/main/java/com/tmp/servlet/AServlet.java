package com.tmp.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String message = "{}";
        //*.1
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(message);

        //*.2
//        resp.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));
    }

}
