package com.emmanuel.app.bean;

import com.emmanuel.app.model.Portfolio;

public interface PortfolioBeanI {
    String portfolios();

    Portfolio addPortfolio(Portfolio portfolio);

    void deletePortfolio(Portfolio portfolio);
}
