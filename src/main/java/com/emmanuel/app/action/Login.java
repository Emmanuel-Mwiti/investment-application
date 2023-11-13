package com.emmanuel.app.action;

import com.emmanuel.app.bean.AuthBeanI;
import com.emmanuel.app.bean.impl.AuthBeanImp;
import com.emmanuel.app.model.entity.User;
import com.emmanuel.database.Database;

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
public class Login extends BaseAction {
    AuthBeanI authBean = new AuthBeanImp();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("./");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        User loginUser = new User();
        serializeForm(loginUser, req.getParameterMap());

        User userDetails = authBean.athenticate(loginUser);

        if (userDetails != null) {
            HttpSession httpSession = req.getSession(true);
            String formattedDate = dateFormat.format(new Date());
            httpSession.setAttribute("loggedInId", formattedDate);
            httpSession.setAttribute("username", loginUser.getName());

            httpSession.setAttribute("loggedInId", new Date().getTime() + "");
            httpSession.setAttribute("username", loginUser.getName());
            httpSession.setAttribute("investmentGoal", loginUser.getInvestmentGoal());

            resp.sendRedirect("./home");

        } else {
            PrintWriter print = resp.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Login again. </a></body></html>");
        }
    }


}