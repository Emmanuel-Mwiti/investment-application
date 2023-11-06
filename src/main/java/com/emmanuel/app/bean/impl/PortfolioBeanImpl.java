package com.emmanuel.app.bean.impl;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.model.Portfolio;
import com.emmanuel.database.Database;

import java.util.List;

public class PortfolioBeanImpl implements PortfolioBeanI {

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
    public void deletePortfolio(Portfolio investment) {
    }
}
