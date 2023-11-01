package com.emmanuel.app.bean.impl;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.model.Investment;
import com.emmanuel.app.model.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioBeanImpl implements PortfolioBeanI {
    @Override
    public String portfolios() {
        List<Portfolio> portfolios = new ArrayList<>();

        // Create a new portfolio - Savings
        Portfolio savingsPortfolio = new Portfolio();
        savingsPortfolio.setId(1L);
        savingsPortfolio.setName("Savings");
        savingsPortfolio.setInvestmentHorizon(5L);
        savingsPortfolio.setExpectedReturnOnInvestment(20.0);

        // Create investments for the Savings portfolio
        List<Investment> investmentsInSavingsPortfolio = new ArrayList<>();
        investmentsInSavingsPortfolio.add(new Investment(1L, "Stocks", 1000.0, 20000.0, 20.0, 100000.0));
        investmentsInSavingsPortfolio.add(new Investment(2L, "Bonds", 2000.0, 15000.0, 50.0, 2000000.0));
        investmentsInSavingsPortfolio.add(new Investment(3L, "Commodities", 18000.0, 15000.0, 30.0, 50000.0));
        savingsPortfolio.setInvestments(investmentsInSavingsPortfolio);

        portfolios.add(savingsPortfolio);

        Portfolio retirementPortfolio = new Portfolio();
        retirementPortfolio.setId(2L);
        retirementPortfolio.setName("Retirement");
        retirementPortfolio.setInvestmentHorizon(10L);
        retirementPortfolio.setExpectedReturnOnInvestment(40.0);

        List<Investment> investmentsInRetirementPortfolio = new ArrayList<>();
        investmentsInRetirementPortfolio.add(new Investment(4L, "Real Estate", 500000.0, 100000.0, 50.0, 900000.0));
        investmentsInRetirementPortfolio.add(new Investment(5L, "Bonds", 2000.0, 15000.0, 50.0, 2000000.0));
        retirementPortfolio.setInvestments(investmentsInRetirementPortfolio);

        portfolios.add(retirementPortfolio);


        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"en\">");
        html.append("<head>");
        html.append("    <meta charset=\"UTF-8\">");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        html.append("    <title>Investment App Homepage</title>");
        html.append("    <style>");
        html.append("        body {");
        html.append("            background-color: #f0f0f0;");
        html.append("            font-family: Arial, sans-serif;");
        html.append("        }");
        html.append("        .header {");
        html.append("            background-color: #007BFF;");
        html.append("            color: white;");
        html.append("            padding: 20px;");
        html.append("            text-align: center;");
        html.append("        }");
        html.append("        .welcome {");
        html.append("            text-align: center;");
        html.append("            margin: 20px;");
        html.append("        }");
        html.append("        .portfolio-container {");
        html.append("            display: flex;");
        html.append("            justify-content: space-around;");
        html.append("            flex-wrap: wrap;");
        html.append("            padding: 20px;");
        html.append("        }");
        html.append("        .portfolio-card {");
        html.append("            background-color: #fff;");
        html.append("            border: 1px solid #ddd;");
        html.append("            border-radius: 5px;");
        html.append("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);");
        html.append("            margin: 10px;");
        html.append("            width: 300px;");
        html.append("            padding: 15px;");
        html.append("        }");
        html.append("        .portfolio-card h3 {");
        html.append("            color: #007BFF;");
        html.append("            font-size: 1.5rem;");
        html.append("            margin: 0;");
        html.append("        }");
        html.append("        .portfolio-description {");
        html.append("            color: #555;");
        html.append("            margin: 10px 0;");
        html.append("        }");
        html.append("        ul {");
        html.append("            list-style: none;");
        html.append("            padding: 0;");
        html.append("        }");
        html.append("        li {");
        html.append("            color: #333;");
        html.append("            margin: 5px 0;");
        html.append("        }");
        html.append("        .performance {");
        html.append("            display: flex;");
        html.append("            justify-content: space-between;");
        html.append("            align-items: center;");
        html.append("        }");
        html.append("        .performance p {");
        html.append("            color: #4CAF50;");
        html.append("            font-weight: bold;");
        html.append("        }");
        html.append("        .analysis-button {");
        html.append("            background-color: #007BFF;");
        html.append("            color: white;");
        html.append("            border: none;");
        html.append("            border-radius: 5px;");
        html.append("            padding: 10px 20px;");
        html.append("            cursor: pointer;");
        html.append("            transition: background-color 0.3s;");
        html.append("        }");
        html.append("        .analysis-button:hover {");
        html.append("            background-color: #0056b3;");
        html.append("        }");
        html.append("    </style>");
        html.append("</head>");
        html.append("<body>");
        html.append("<div class=\"header\">");
        html.append("    <h1>Welcome Back, Emmanuel Mwiti!</h1>");
        html.append("    <p>Logged in at (dynamic log time and date)</p>");
        html.append("</div>");
        html.append("<div class=\"welcome\">");
        html.append("    <p>This is your investment dashboard.</p>");
        html.append("</div>");
        html.append("<div class=\"portfolio-container\">");

        for (Portfolio portfolio : portfolios) {
            html.append("    <div class=\"portfolio-card\">");
            html.append("        <h3>").append(portfolio.getName()).append("</h3>");
            html.append("        <p class=\"portfolio-description\">").append(portfolio.getName()).append(" Portfolio.</p>");
            html.append("        <ul>");

            for (Investment investment : portfolio.getInvestments()) {
                html.append("            <li>").append("Asset Class ").append(investment.getId()).append(": ").append(investment.getName()).append("</li>");
            }

            html.append("        </ul>");
            html.append("        <div class=\"performance\">");
            html.append("            <p>Performance: ").append(portfolio.getExpectedReturnOnInvestment()).append("%</p>");
            html.append("            <button class=\"analysis-button\">Analyze Risk</button>");
            html.append("        </div>");
            html.append("    </div>");
        }

        html.append("</div>");
        html.append("</body>");
        html.append("</html>");

        return html.toString();
    }

    @Override
    public Investment addOrUpdateInvestment(Investment investment) {
        // Implement the logic to add or update an investment
        return investment;
    }

    @Override
    public void deleteInvestment(Investment investment) {
        // Implement the logic to delete an investment
    }

    @Override
    public void deletePortfolio(Portfolio portfolio) {
        // Implement the logic to delete a portfolio
    }
}
