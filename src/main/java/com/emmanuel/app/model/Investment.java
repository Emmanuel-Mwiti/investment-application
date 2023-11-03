package com.emmanuel.app.model;

import java.io.Serializable;

/**
 * Created by emmanuel on 11/1/23
 *
 * @author: emmanuel
 * @date: 11/1/23
 * @project: IntelliJ IDEA
 */
public class Investment implements Serializable {
    private Long id;
    private String name;
    private Double initialAmount;
    private Double expectedAnnualAverageReturn;
    private Double targetAllocation;
    private Double finalAmount;

    public Investment() {
    }

    public Investment(Long id, String name, Double initialAmount, Double expectedAnnualAverageReturn, Double targetAllocation, Double finalAmount) {
        this.id = id;
        this.name = name;
        this.initialAmount = initialAmount;
        this.expectedAnnualAverageReturn = expectedAnnualAverageReturn;
        this.targetAllocation = targetAllocation;
        this.finalAmount = finalAmount;
    }

    public Double getFinalValue() {
        return finalAmount;
    }

    public void setFinalValue(Double finalAmount) {
        this.finalAmount = finalAmount;
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

    public Double getInitialInvestmentAmount() {
        return initialAmount;
    }

    public void setInitialInvestmentAmount(Double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Double getExpectedAnnualAverageReturn() {
        return expectedAnnualAverageReturn;
    }

    public void setExpectedAnnualAverageReturn(Double expectedAnnualAverageReturn) {
        this.expectedAnnualAverageReturn = expectedAnnualAverageReturn;
    }

    public Double getTargetAllocation() {
        return targetAllocation;
    }

    public void setTargetAllocation(Double targetAllocation) {
        this.targetAllocation = targetAllocation;
    }
}
