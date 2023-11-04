package com.emmanuel.app.view.html;

import com.emmanuel.app.view.css.AppCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest request, HttpServletResponse response, String content) throws IOException {
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
                "    <h1>Welcome Back, " + session.getAttribute("username") + "!</h1>" +
                "    <h2>Your login time is: " + session.getAttribute("loggedInId") + "!</h2>" +
                "</div>" +
                "<div class=\"user-card\">" +
                "    <h2>User Details</h2>" +
                "    <p>Username: " + session.getAttribute("username") + "</p>" +
                "    <p>Investment Goal: " + session.getAttribute("investmentGoal") + " please before spending be aware of this!</p>" +
                "</div>" +
                "<div class=\"welcome\">" +
                "    <p>This is your Portfolios dashboard.</p>" +
                "<table>" +
                "    <tr>" +
                "        <th>Portfolio Name</th>" +
                "        <th>Investment Horizon</th>" +
                "        <th>Expected ROI</th>" +
                "        <th>Performance</th>" +
                "        <th>Comment Based on expected ROI</th>" +
                content +
                "</table>" +
                "</div>" +
                "<div class=\"add-portfolio-button-container\">" +
                "    <a class=\"add-portfolio-button\" href=\"add-portfolio\">Add Portfolio</a>" +
                "</div>" +
                "<a href=\"./logout\">Logout</a>" +
                "</body>" +
                "</html>");
    }
}
