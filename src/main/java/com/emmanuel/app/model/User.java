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
    private Long id;
    private String name;
    private String password;
    private String investmentGoal;

    public User() {
    }

    public User(Long id, String name, String password, String investmentGoal) {
        this.name = name;
        this.password = password;
        this.investmentGoal = investmentGoal;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
