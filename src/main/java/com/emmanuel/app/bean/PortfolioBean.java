package com.emmanuel.app.bean;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.database.Database;

import java.io.Serializable;
import java.util.List;

public class PortfolioBean implements PortfolioBeanI, Serializable {

    @Override
    public String portfolios() {
        List<Portfolio> portfolios = Database.getDbInstance().getPortfolios();

        StringBuilder cardBuilder = new StringBuilder();

        cardBuilder.append("<table><tr>" +
                "<th>Portfolio Name</th>" +
                "<th>Investment Horizon(years)</th>" +
                "<th>Expected ROI(%)</th>" +
                "<th>Performance(%)</th>" +
                "<th>Comment Based on expected ROI</th>" +
                "</tr>");

        for (Portfolio portfolio : portfolios)
            cardBuilder.append(portfolio.tableRow());

        cardBuilder.append("</table>");

        return cardBuilder.toString();
    }

    @Override
    public Portfolio addPortfolio(Portfolio portfolio) {
        Database database = Database.getDbInstance();
        database.getPortfolios().add(portfolio);
        return portfolio;
    }

    @Override
    public void deletePortfolio(String portfolioId) {
        Database database = Database.getDbInstance();
        List<Portfolio> portfolios = database.getPortfolios();

        Portfolio portfolioToRemove = null;
        for (Portfolio portfolio : portfolios) {
            if (portfolio.getId().equals(portfolioId)) {
                portfolioToRemove = portfolio;
                break;
            }
        }

        if (portfolioToRemove != null) {
            portfolios.remove(portfolioToRemove);
            System.out.println("Portfolio removed successfully. ID: " + portfolioId);
        } else {
            System.out.println("Portfolio not found. ID: " + portfolioId);
        }
    }
}
