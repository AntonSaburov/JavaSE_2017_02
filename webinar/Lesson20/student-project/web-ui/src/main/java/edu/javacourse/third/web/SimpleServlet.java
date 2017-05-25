package edu.javacourse.third.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by antonsaburov on 18.05.17.
 */
public class SimpleServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String name = req.getParameter("surName");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");
        resp.getWriter().append("<strong>HELLO, " + name + "</strong>");
    }
}
