package com.emmanuel.auth;

import com.emmanuel.database.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by emmanuel on 10/31/23
 *
 * @author: emmanuel
 * @date: 10/31/23
 * @project: IntelliJ IDEA
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("./");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ServletContext servletContext = getServletContext();
        HttpSession httpSession = req.getSession(true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String formattedDate = dateFormat.format(new Date());
        httpSession.setAttribute("loggedInId", formattedDate);
        httpSession.setAttribute("username", username);

        if (username.equals(servletContext.getInitParameter("username")) && password.equals(servletContext.getInitParameter("password"))) {
            resp.sendRedirect("./home");

        } else {
            PrintWriter print = resp.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Login again. If you are not signed up, please sign up </a></body></html>");
        }

    }
}