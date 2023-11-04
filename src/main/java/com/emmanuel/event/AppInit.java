package com.emmanuel.event;

import com.emmanuel.app.model.Portfolio;
import com.emmanuel.app.model.User;
import com.emmanuel.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Created by emmanuel on 11/4/23
 *
 * @author: emmanuel
 * @date: 11/4/23
 * @project: IntelliJ IDEA
 */
@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*************** Initializing database *************");

        Database database = Database.getDbInstance();

        database.getUsers().add(new User(0L,"emmanuel.mwiti@test.com", "1234","To buy a car"));
        database.getUsers().add(new User(0L, "shady.amuku@test.com", "1234","To buy a car"));

        database.getPortfolios().add(new Portfolio(1L, "Savings", 5L, 20.0));
        database.getPortfolios().add(new Portfolio(1L, "Retirement", 10L, 40.0));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Application is undeployed or destroyed");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}