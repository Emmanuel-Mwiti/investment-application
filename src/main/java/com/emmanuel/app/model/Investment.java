package com.emmanuel.app.model;

import com.emmanuel.app.model.AssetClass;

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
    private AssetClass assetClass;
    private Double initialAmount;
    private Double targetAllocation;
    private Double finalAmount;

    public Investment() {
    }

    public Investment(Long id, AssetClass assetClass, Double initialAmount, Double targetAllocation, Double finalAmount) {
        this.id = id;
        this.assetClass = assetClass;
        this.initialAmount = initialAmount;
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
