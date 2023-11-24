package com.emmanuel.app.view.html;

import com.emmanuel.app.view.Toolbar.TopToolBar;
import com.emmanuel.app.view.css.AppCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest request, HttpServletResponse response, String content, int activeMenu) throws IOException {
        HttpSession session = request.getSession();

        PrintWriter print = response.getWriter();

        print.write("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>Investment App Homepage</title>" +
                new AppCss().getStyle() +
                "</head>" +
                "<body>" +
                "<div class=\"header\">" +
                "    <h1>Welcome, " + session.getAttribute("username") + "!</h1>" +
                "    <h2>Your login time is: " + session.getAttribute("loggedInId") + "!</h2>" +
                "</div>" +
                "<div class=\"user-card\">" +
                "    <h2>User Details</h2>" +
                "    <p>Username: " + session.getAttribute("username") + "</p>" +
//                "    <p>Investment Goal: " + session.getAttribute("investmentGoal") + " please before spending be aware of this!</p>" +
                "</div>" +
                "<div class=\"welcome\">" +
                new TopToolBar().menu(activeMenu)+
                content +
                "</div>" +
                "</body>" +
                "</html>");
    }
}
