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


        StringBuilder cardBuilder = new StringBuilder();


        for (Portfolio portfolio : portfolios) {
            cardBuilder.append("    <div class=\"portfolio-card\">");
            cardBuilder.append("        <h3>").append(portfolio.getName()).append("</h3>");
            cardBuilder.append("        <p class=\"portfolio-description\">").append(portfolio.getName()).append(" Portfolio.</p>");
            cardBuilder.append("        <ul>");

            for (Investment investment : portfolio.getInvestments()) {
                cardBuilder.append("            <li>").append("Asset Class ").append(investment.getId()).append(": ").append(investment.getName()).append("</li>");
            }

            cardBuilder.append("        </ul>");
            cardBuilder.append("        <div class=\"performance\">");
            cardBuilder.append("            <p>Performance: ").append(portfolio.getExpectedReturnOnInvestment()).append("%</p>");
            cardBuilder.append("            <button class=\"analysis-button\">Analyze Risk</button>");
            cardBuilder.append("        </div>");
            cardBuilder.append("    </div>");
        }


        return cardBuilder.toString();
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
