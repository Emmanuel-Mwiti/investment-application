package com.emmanuel.auth;

import com.emmanuel.app.model.User;
import com.emmanuel.database.Database;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by emmanuel on 11/4/23
 *
 * @author: emmanuel
 * @date: 11/4/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/sign-up")
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
            Database dbInstance = Database.getDbInstance();
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String investmentGoal = req.getParameter("investmentGoal");
            dbInstance.getUsers().add(new User(1L, username, password, investmentGoal));
            resp.sendRedirect("./");

        } else
            resp.sendRedirect("./");
    }
}
