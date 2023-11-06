package com.emmanuel.app.model;

import java.io.Serializable;

public class User implements Serializable {
    private static long nextId = 1;

    private Long id;
    private String name;
    private String password;
    private String investmentGoal;

    public User() {
        this.id = generateNextId();
    }

    public User(String name, String password, String investmentGoal) {
        this.id = generateNextId();
        this.name = name;
        this.password = password;
        this.investmentGoal = investmentGoal;
    }

    private Long generateNextId() {
        return nextId++;
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
