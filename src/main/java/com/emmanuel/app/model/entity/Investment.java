package com.emmanuel.app.model.entity;

import java.io.Serializable;

public class Investment implements Serializable {
    private static long nextId = 1;
    private Long id;
    private AssetClass assetClass;
    private Double initialAmount;
    private Double targetAllocation;
    private Double finalAmount;

    public Investment() {
        this.id = generateNextId();
    }

    public Investment(AssetClass assetClass, Double initialAmount, Double targetAllocation, Double finalAmount) {
        this.id = generateNextId();
        this.assetClass = assetClass;
        this.initialAmount = initialAmount;
        this.targetAllocation = targetAllocation;
        this.finalAmount = finalAmount;
    }

    private Long generateNextId() {
        return nextId++;
    }

    public Double getFinalValue() {
        return finalAmount;
    }
    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public void setFinalValue(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Long getId() {
        return id;
    }


    public AssetClass getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(AssetClass assetClass) {
        this.assetClass = assetClass;
    }

    public Double getInitialInvestmentAmount() {
        return initialAmount;
    }

    public void setInitialInvestmentAmount(Double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Double getTargetAllocation() {
        return targetAllocation;
    }

    public void setTargetAllocation(Double targetAllocation) {
        this.targetAllocation = targetAllocation;
    }
}
