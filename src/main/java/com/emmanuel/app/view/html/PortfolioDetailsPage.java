package com.emmanuel.app.view.html;

import com.emmanuel.app.model.entity.Investment;
import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.view.css.PortfolioDetailsCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PortfolioDetailsPage {

    public void renderHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter print = response.getWriter();

        Portfolio portfolio = (Portfolio) session.getAttribute("selectedPortfolio");
        List<Investment> investments = portfolio.getInvestments();

        print.write("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>Portfolio Details - Investment App</title>" +
                new PortfolioDetailsCss().getStyle() +
                "</head>" +
                "<body>" +
                "<div class=\"portfolio-details\">" +
                "    <h2>Portfolio Details</h2>" +
                "    <p>Portfolio Name: " + portfolio.getName() + "</p>" +
                "    <p>Investment Horizon: " + portfolio.getInvestmentHorizon() + " years</p>" +
                "    <p>Expected ROI: " + portfolio.getExpectedReturnOnInvestment() + "%</p>" +
                "<div class=\"button-container\">" +
                "    <form action=\"analyze-risk\" method=\"post\">" +
                "        <button class=\"analyze-risk-button\" type=\"submit\">Analyze Risk</button>" +
                "    </form>" +
                "    <form action=\"add-investment\" method=\"post\">" +
                "        <button class=\"add-investment-button\" type=\"submit\">Add Investment</button>" +
                "    </form>" +
                "</div>" +
                "</div>");

        print.write("<div class=\"investment-table\">");
        print.write("<h3>Investments:</h3>");
        print.write("<table>");
        print.write("<tr>");
        print.write("<th>Asset Class</th>");
        print.write("<th>Initial Amount</th>");
        print.write("<th>Target Allocation</th>");
        print.write("<th>Final Amount</th>");
        print.write("</tr>");

        for (Investment investment : investments) {
            print.write("<tr>");
            print.write("<td>" + investment.getAssetClass() + "</td>");
            print.write("<td>" + investment.getInitialInvestmentAmount() + "</td>");
            print.write("<td>" + investment.getTargetAllocation() + "</td>");
            print.write("<td>" + investment.getFinalValue() + "</td>");
            print.write("</tr>");
        }

        print.write("</table>");
        print.write("</div>");

        print.write("</body>" +
                "</html>");
    }
}
