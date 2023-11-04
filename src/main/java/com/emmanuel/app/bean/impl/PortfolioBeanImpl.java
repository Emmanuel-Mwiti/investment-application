package com.emmanuel.app.bean.impl;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.model.Investment;
import com.emmanuel.app.model.Portfolio;
import com.emmanuel.database.Database;

import java.util.ArrayList;
import java.util.List;

public class PortfolioBeanImpl implements PortfolioBeanI {
        @Override
        public String portfolios() {
            List<Portfolio> portfolios = Database.getDbInstance().getPortfolios();

            StringBuilder cardBuilder = new StringBuilder();

            for (Portfolio portfolio : portfolios) {
                cardBuilder.append("    <tr>");
                cardBuilder.append("        <td>").append(portfolio.getName()).append("</td>");
                cardBuilder.append("        <td>").append(portfolio.getInvestmentHorizon()).append(" years</td>");
                cardBuilder.append("        <td>").append(portfolio.getExpectedReturnOnInvestment()).append("%</td>");
                cardBuilder.append("        <td>40%</td>");
                cardBuilder.append("        <td>Over performed</td>");
                cardBuilder.append("        <td>");
                cardBuilder.append("<a class=\"delete-portfolio-button\" href=\"./portfolio-details\">Details</a>");
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
