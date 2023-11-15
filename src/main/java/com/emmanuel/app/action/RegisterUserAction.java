package com.emmanuel.app.action;

import com.emmanuel.app.bean.UserBeanI;
import com.emmanuel.app.bean.impl.UserBeanImpl;
import com.emmanuel.app.model.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sign-up")
public class RegisterUserAction extends BaseAction {

    UserBeanI userBean = new UserBeanImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();

        serializeForm(user, req.getParameterMap());
        userBean.addUser(user);
//
//        String username = req.getParameter("name");
//        String password = req.getParameter("password");
//        String investmentGoal = req.getParameter("investmentGoal");
//
//        User user = new User(username, password, investmentGoal);
        userBean.addUser(user);
        resp.sendRedirect("./");
    }
}
