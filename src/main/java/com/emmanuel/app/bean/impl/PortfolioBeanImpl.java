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
            cardBuilder.append("    <tr>");
            cardBuilder.append("        <td>").append(portfolio.getName()).append("</td>");
            cardBuilder.append("        <td>").append(portfolio.getInvestmentHorizon()).append(" years</td>");
            cardBuilder.append("        <td>").append(portfolio.getExpectedReturnOnInvestment()).append("%</td>");
            cardBuilder.append("        <td>");
            cardBuilder.append("            <button class=\"analysis-button\">Analyze Risk</button>");
            cardBuilder.append("        </td>");
            cardBuilder.append("    </tr>");
        }



        return cardBuilder.toString();
    }

    @Override
    public Investment addOrUpdateInvestment(Investment investment) {
        return null;
    }

    @Override
    public void deleteInvestment(Investment investment) {
    }

    @Override
    public void deletePortfolio(Portfolio portfolio) {
    }
}
