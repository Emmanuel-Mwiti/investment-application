package com.emmanuel.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by emmanuel on 11/3/23
 *
 * @author: emmanuel
 * @date: 11/3/23
 * @project: IntelliJ IDEA
 */
@WebServlet(urlPatterns = "/logout")
public class Logout  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("./");
    }
}

