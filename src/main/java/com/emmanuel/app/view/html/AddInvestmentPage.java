package com.emmanuel.app.view.html;

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
                "    <h1>Welcome Back, " + session.getAttribute("username") + "!</h1>" +
                "    <h2>Your login time is: " + session.getAttribute("loggedInId") + "!</h2>" +
                "</div>" +
                "<div class=\"form-container\">" +
                "    <h2>Add Investment</h2>" +
                "    <form action=\"add-investment-action\" method=\"post\">" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"investmentType\">Investment Type:</label>" +
                "            <select class=\"form-input\" name=\"investmentType\">" +
                "                <option value=\"stocks\">Stocks</option>" +
                "                <option value=\"bonds\">Bonds</option>" +
                "                <option value=\"real-estate\">Real Estate</option>" +
                "                <option value=\"cash-money-market\">Cash/Money Market</option>" +
                "                <option value=\"commodities\">Commodities</option>" +
                "            </select>" +
                "        </div>" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"initialAmount\">Initial Amount:</label>" +
                "            <input class=\"form-input\" type=\"number\" id=\"initialAmount\" name=\"initialAmount\" required>" +
                "        </div>" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"finalAmount\">Final Amount:</label>" +
                "            <input class=\"form-input\" type=\"number\" id=\"finalAmount\" name=\"finalAmount\" required>" +
                "        </div>" +
                "        <div class=\"form-group\">" +
                "            <label class=\"form-label\" for=\"targetAllocation\">Target Allocation (%):</label>" +
                "            <input class=\"form-input\" type=\"number\" id=\"targetAllocation\" name=\"targetAllocation\" required>" +
                "        </div>" +
                "        <button class=\"form-button\" type=\"submit\">Add Investment</button>" +
                "    </form>" +
                "</div>" +
                "</body>" +
                "</html>");
    }
}
