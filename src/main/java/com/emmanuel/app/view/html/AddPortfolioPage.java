package com.emmanuel.app.view.html;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.view.css.AddPortfolioCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddPortfolioPage {
    public void renderHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter print = response.getWriter();

        print.write("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>Add Portfolio - Investment App</title>" +
                new AddPortfolioCss().getStyle() +
                "</head>" +
                "<body>" +
                "<div class=\"form-container\">" +
                "<form action=\"" + request.getContextPath() + "/add-portfolio\"method=\"POST\" class=\"#\">" +
                "    <div class=\"form-group\">" +
                "        <label for=\"portfolioName\" class=\"form-label\">Portfolio Name:</label><br>" +
                "        <input type=\"text\" id=\"portfolioName\" name=\"name\" class=\"form-input\"><br>" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label for=\"investmentHorizon\" class=\"form-label\">Investment Horizon:</label><br>" +
                "        <input type=\"text\" id=\"investmentHorizon\" name=\"investmentHorizon\" class=\"form-input\"><br>" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label for=\"expectedReturn\" class=\"form-label\">Expected Return on Investment:</label><br>" +
                "        <input type=\"text\" id=\"expectedReturn\" name=\"expectedReturnOnInvestment\" class=\"form-input\"><br>" +
                "    </div>" +
                "    <input type=\"submit\" value=\"Add Portfolio\" class=\"form-button\">" +
                "</form>" +
//                CustomHtml.form(Portfolio.class)+
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
