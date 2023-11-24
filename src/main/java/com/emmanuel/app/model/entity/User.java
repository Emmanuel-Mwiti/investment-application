package com.emmanuel.app.model.entity;

import com.emmanuel.database.helper.DbTable;
import com.emmanuel.database.helper.DbTableColumn;

import java.io.Serializable;
@DbTable(tableName = "users")
public class User implements Serializable {
//    @DbTableColumn(columnName = "user_id")
    private Long id;
    @DbTableColumn(columnName = "user_name")
    private String name;
    @DbTableColumn(columnName = "user_password")
    private String password;
    @DbTableColumn(columnName = "investment_goal")
    private String investmentGoal;
    public User(){

    }
    public User(String name, String password, String investmentGoal) {
        this.name = name;
        this.password = password;
        this.investmentGoal = investmentGoal;
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
