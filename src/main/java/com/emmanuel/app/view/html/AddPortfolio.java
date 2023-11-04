package com.emmanuel.app.view.html;

import com.emmanuel.app.view.css.AddPortfolioCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddPortfolio {
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
                "<div class=\"header\">" +
                "    <h1>Welcome Back, " + session.getAttribute("username") + "!</h1>" +
                "    <h2>Your login time is: " + session.getAttribute("loggedInId") + "!</h2>" +
                "</div>" +
                "<div class=\"form-container\">" +
                "    <h2>Add Portfolio</h2>" +
                "    <form action=\"add-portfolio\" method=\"post\">" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"portfolioName\">Portfolio Name:</label>" +
                "            <input class=\"form-input\" type=\"text\" id=\"portfolioName\" name=\"portfolioName\" required>" +
                "        </div>" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"investmentHorizon\">Investment Horizon (years):</label>" +
                "            <input class=\"form-input\" type=\"number\" id=\"investmentHorizon\" name=\"investmentHorizon\" required>" +
                "        </div>" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"expectedROI\">Expected ROI (%):</label>" +
                "            <input class=\"form-input\" type=\"number\" id=\"expectedROI\" name=\"expectedROI\" required>" +
                "        </div>" +
                "        <div class=\"investment-list\">" +
                "            <h3>Investments</h3>" +
                "            <div class=\"investment-entry\">" +
                "                <label class=\"form-label\" for=\"investmentType\">Investment Type:</label>" +
                "                <select class=\"form-input\" name=\"investmentType[]\">" +
                "                    <option value=\"stocks\">Stocks</option>" +
                "                    <option value=\"bonds\">Bonds</option>" +
                "                    <option value=\"real-estate\">Real Estate</option>" +
                "                    <option value=\"cash-money-market\">Cash/Money Market</option>" +
                "                    <option value=\"commodities\">Commodities</option>" +
                "                </select>" +
                "                <label class=\"form-label\" for=\"initialAmount\">Initial Amount:</label>" +
                "                <input class=\"form-input\" type=\"number\" name=\"initialAmount[]\">" +
                "                <label class=\"form-label\" for=\"finalAmount\">Final Amount:</label>" +
                "                <input class=\"form-input\" type=\"number\" name=\"finalAmount[]\">" +
                "                <label class=\"form-label\" for=\"targetAllocation\">Target Allocation (%):</label>" +
                "                <input class=\"form-input\" type=\"number\" name=\"targetAllocation[]\">" +
                "            </div>" +
                "            <!-- Additional investment entries can be added dynamically -->" +
                "        </div>" +
                "        <button class=\"form-button\" type=\"button\" onclick=\"addInvestmentEntry()\">Add Investment</button>" +
                "        <button class=\"form-button\" type=\"submit\">Add Portfolio</button>" +
                "    </form>" +
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
