package com.emmanuel.app.model.entity;

import com.emmanuel.app.view.html.HtmlForm;
import com.emmanuel.app.view.html.HtmlFormField;
import com.emmanuel.database.helper.DbTable;
import com.emmanuel.database.helper.DbTableColumn;

import java.io.Serializable;
@HtmlForm(label = "Portfolios", url = "./addInvestment")
@DbTable(tableName = "investments")
public class Investment implements Serializable {
    private static long nextId = 1;
    private Long id;
    @HtmlFormField(label = "Asset class")
    private AssetClass assetClass;
    @HtmlFormField(label = "Initial Amount")
    @DbTableColumn(columnName = "initial_amount")
    private Double initialAmount;
    @HtmlFormField(label = "Portfolio Name")
    @DbTableColumn(columnName = "target_allocation")
    private Double targetAllocation;
    @DbTableColumn(columnName = "final_amount")
    @HtmlFormField(label = "Portfolio Name")
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
