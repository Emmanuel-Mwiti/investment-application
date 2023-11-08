package com.emmanuel.app.bean;

import com.emmanuel.app.model.entity.Portfolio;

public interface PortfolioBeanI {
    String portfolios();

    Portfolio addPortfolio(Portfolio portfolio);

    void deletePortfolio(Portfolio portfolio);
}
