package com.emmanuel.app.model;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by emmanuel on 11/1/23
 *
 * @author: emmanuel
 * @date: 11/1/23
 * @project: IntelliJ IDEA
 */
public class Portfolio implements Serializable {
    private Long id;
    private String name;
    private Long investmentHorizon;
    private Double expectedReturnOnInvestment;
    private List<Investment> investments;

    public Portfolio() {
    }

    public Portfolio(Long id, String name, Long investmentHorizon, Double expectedReturnOnInvestment, List<Investment> investments) {
        this.id = id;
        this.name = name;
        this.investmentHorizon = investmentHorizon;
        this.expectedReturnOnInvestment = expectedReturnOnInvestment;
        this.investments = investments;
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

    public Long getInvestmentHorizon() {
        return investmentHorizon;
    }

    public void setInvestmentHorizon(Long investmentHorizon) {
        this.investmentHorizon = investmentHorizon;
    }

    public Double getExpectedReturnOnInvestment() {
        return expectedReturnOnInvestment;
    }

    public void setExpectedReturnOnInvestment(Double expectedReturnOnInvestment) {
        this.expectedReturnOnInvestment = expectedReturnOnInvestment;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }

}
