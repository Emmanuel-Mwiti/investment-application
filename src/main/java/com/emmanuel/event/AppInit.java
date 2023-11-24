package com.emmanuel.event;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.model.entity.User;
import com.emmanuel.app.model.entity.Investment;
import com.emmanuel.app.model.entity.AssetClass;
import com.emmanuel.database.Database;
import com.emmanuel.database.MysqlDatabase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class AppInit implements ServletContextListener {

//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("*************** Initializing database *************");
//
//        Database database = Database.getDbInstance();
//
//        database.getUsers().add(new User("emmanuel.mwiti@test.com", "1234", "To buy a car"));
//        database.getUsers().add(new User("shady.amuku@test.com", "1234", "To buy a land"));
//
//        Portfolio savingsPortfolio = new Portfolio("Savings", 5L, 20.0);
//        Portfolio retirementPortfolio = new Portfolio("Retirement", 10L, 40.0);
//
//
//        Investment savingsInvestment1 = new Investment(AssetClass.STOCKS, 1000.0, 40.0, 1200.0);
//        Investment savingsInvestment2 = new Investment(AssetClass.BONDS, 2000.0, 60.0, 2400.0);
//        List<Investment> savingsPortfolioInvestments = new ArrayList<>();
//        savingsPortfolioInvestments.add(savingsInvestment1);
//        savingsPortfolioInvestments.add(savingsInvestment2);
//        savingsPortfolio.setInvestments(savingsPortfolioInvestments);
//
//        Investment retirementInvestment1 = new Investment(AssetClass.COMMODITIES, 3000.0, 70.0, 3600.0);
//        Investment retirementInvestment2 = new Investment(AssetClass.MONEY_MARKET, 4000.0, 80.0, 4800.0);
//        List<Investment> retirementInvestments = new ArrayList<>();
//        retirementInvestments.add(retirementInvestment1);
//        retirementInvestments.add(retirementInvestment2);
//        retirementPortfolio.setInvestments(retirementInvestments);
//
//        database.getPortfolios().add(savingsPortfolio);
//        database.getPortfolios().add(retirementPortfolio);
//    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MysqlDatabase.updateSchema();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Application is undeployed or destroyed");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
