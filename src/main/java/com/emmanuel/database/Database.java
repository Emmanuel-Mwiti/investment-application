package com.emmanuel.database;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.model.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emmanuel on 11/4/23
 *
 * @author: emmanuel
 * @date: 11/4/23
 * @project: IntelliJ IDEA
 */
public class Database implements Serializable {
    private List<Portfolio> portfolios = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static Database databaseInstance;


    public static Database getDbInstance() {
        if (databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }
    public Portfolio findPortfolioById(Long portfolioId) {
        for (Portfolio portfolio : portfolios) {
            if (portfolio.getId().equals(portfolioId)) {
                return portfolio;
            }
        }
        return null; // Portfolio not found
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
