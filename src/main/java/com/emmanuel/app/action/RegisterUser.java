package com.emmanuel.app.action;

import com.emmanuel.app.bean.UserBeanI;
import com.emmanuel.app.bean.impl.UserBeanImpl;
import com.emmanuel.app.model.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/sign-up")
public class RegisterUser extends BaseAction {

    UserBeanI userBean = new UserBeanImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        User user = new User();
//
//        serializeForm(user, req.getParameterMap());
//        userBean.addUser(user);

        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String investmentGoal = req.getParameter("investmentGoal");

        User user = new User(username, password, investmentGoal);
        userBean.addUser(user);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Received user registration request: " + user);
        System.out.println();
        System.out.println();
        System.out.println();

        resp.sendRedirect("./");
    }
}
