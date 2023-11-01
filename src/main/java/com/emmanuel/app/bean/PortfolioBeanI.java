package com.emmanuel.app.bean;

import com.emmanuel.app.model.Investment;
import com.emmanuel.app.model.Portfolio;

public interface PortfolioBeanI {
    String portfolios();

    Investment addOrUpdateInvestment(Investment investment);

    void deleteInvestment(Investment investment);

    void deletePortfolio(Portfolio portfolio);
}
