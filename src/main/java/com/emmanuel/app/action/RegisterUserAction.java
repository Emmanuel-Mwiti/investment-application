package com.emmanuel.app.action;

import com.emmanuel.app.bean.UserBeanI;
import com.emmanuel.app.bean.UserBean;
import com.emmanuel.app.model.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/sign-up")
public class RegisterUserAction extends BaseAction {

    UserBeanI userBean = new UserBean();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();

        serializeForm(user, req.getParameterMap());
        try {
            userBean.register(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//
//        String username = req.getParameter("name");
//        String password = req.getParameter("password");
//        String investmentGoal = req.getParameter("investmentGoal");
//
//        User user = new User(username, password, investmentGoal);
//        userBean.addUser(user);
        resp.sendRedirect("./");
    }
}
