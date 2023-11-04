package com.emmanuel.app.model;

import java.io.Serializable;

/**
 * Created by emmanuel on 11/3/23
 *
 * @author: emmanuel
 * @date: 11/3/23
 * @project: IntelliJ IDEA
 */
public class User implements Serializable {
    private String name;
    private String password;
    private String investmentGoal;

    public User() {
    }

    public User(String name, String password, String investmentGoal) {
        this.name = name;
        this.password = password;
        this.investmentGoal = investmentGoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInvestmentGoal() {
        return investmentGoal;
    }

    public void setInvestmentGoal(String investmentGoal) {
        this.investmentGoal = investmentGoal;
    }


}
