package com.emmanuel.app.view.html;

import com.emmanuel.app.model.entity.Investment;
import com.emmanuel.app.view.css.AddPortfolioCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddInvestmentPage {
    public void renderHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        PrintWriter print = response.getWriter();

        print.write("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>Add Investment - Investment App</title>" +
                new AddPortfolioCss().getStyle() +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"AddPortfolio.css\">" +
                "</head>" +
                "<body>" +
                "<div class=\"header\">" +
                "    <h1>Welcome, " + session.getAttribute("username") + "!</h1>" +
                "    <h2>Your login time is: " + session.getAttribute("loggedInId") + "!</h2>" +
                "</div>" +
                "<div class=\"form-container\">" +
                "    <h2>Add Investment</h2>" +
                CustomHtml.form(Investment.class) +
                "</div>" +
                "</body>" +
                "</html>");
    }
}
