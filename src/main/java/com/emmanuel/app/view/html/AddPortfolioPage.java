package com.emmanuel.app.view.html;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.view.css.AddPortfolioCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddPortfolioPage {
    public void renderHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        PrintWriter print = response.getWriter();

        print.write("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>Add Portfolio - Investment App</title>" +
                new AddPortfolioCss().getStyle() +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"AddPortfolio.css\">" +
                "</head>" +
                "<body>" +
                "<div class=\"form-container\">" +
                CustomHtml.form(Portfolio.class) +
                "</div>" +
                "<script>" +
                "    function addInvestmentEntry() {" +
                "        var investmentList = document.querySelector('.investment-list');" +
                "        var newInvestmentEntry = document.querySelector('.investment-entry').cloneNode(true);" +
                "        investmentList.appendChild(newInvestmentEntry);" +
                "    }" +
                "</script>" +
                "</body>" +
                "</html>");
    }
}