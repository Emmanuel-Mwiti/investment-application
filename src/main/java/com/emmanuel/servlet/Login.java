package com.emmanuel.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by emmanuel on 10/31/23
 *
 * @author: emmanuel
 * @date: 10/31/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");



        if (username.equals("Emmanuel") && password.equals("1234")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("./app/home.html");
            dispatcher.include(req, resp);

        } else {
            PrintWriter print = resp.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Login again. If you are not signed up, please sign up </a></body></html>");
        }

    }
}
