package com.emmanuel.home;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by emmanuel on 11/1/23
 *
 * @author: emmanuel
 * @date: 11/1/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/home")
public class Home extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            PrintWriter print = resp.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Hello, you are now logged in </a></body></html>");

    }
}
