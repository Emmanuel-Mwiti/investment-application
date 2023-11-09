package com.emmanuel.app.model.entity;


import com.emmanuel.app.model.entity.Investment;
import com.emmanuel.app.view.html.ManuHtmlForm;
import com.emmanuel.app.view.html.ManuHtmlFormField;
import com.emmanuel.app.view.html.ManuTableColumnHeader;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by emmanuel on 11/1/23
 *
 * @author: emmanuel
 * @date: 11/1/23
 * @project: IntelliJ IDEA
 */
@ManuHtmlForm(label = "Portfolios", url = "./add-portfolio")
public class Portfolio implements Serializable {
    private static long nextId = 1;
    private Long id;
    @ManuTableColumnHeader(header = "Portfolio Name")
    @ManuHtmlFormField(label = "Portfolio Name")
    private String name;
    @ManuHtmlFormField(label = "Investment Horizon")
    private Long investmentHorizon;
    @ManuHtmlFormField(label = "Expected Return on Investment")
    private Double expectedReturnOnInvestment;
    private Double performance;
    private String comment;
    private List<Investment> investments;

    public Portfolio() {
        this.id = generateNextId();
    }

    public Portfolio(String name, Long investmentHorizon, Double expectedReturnOnInvestment) {
        this.id = generateNextId();
        this.name = name;
        this.investmentHorizon = investmentHorizon;
        this.expectedReturnOnInvestment = expectedReturnOnInvestment;
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

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }

    public String tableRow() {
        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<tr>");
        trBuilder.append("<td>").append(StringUtils.trimToEmpty(getName())).append("</td>");
        trBuilder.append("<td>").append(getInvestmentHorizon() == null ? " " : getInvestmentHorizon()).append("</td>");
        trBuilder.append("<td>").append(getExpectedReturnOnInvestment() == null ? "" : getExpectedReturnOnInvestment()).append("</td>");
        trBuilder.append("<td>").append(getPerformance() == null ? "" : getPerformance()).append("</td>");
        trBuilder.append("<td>").append(StringUtils.trimToEmpty("Over performed")).append("</td>");

        trBuilder.append("<td><a href='portfolio-details?portfolioId=").append(getId()).append("'>View Details</a></td>");

        trBuilder.append("<td><form method='post' action='delete-portfolio'>");
        trBuilder.append("<input type='hidden' name='portfolioId' value='").append(getId()).append("'>");
        trBuilder.append("<button type='submit'>Delete</button>");
        trBuilder.append("</form></td>");

        trBuilder.append("</tr>");

        return trBuilder.toString();
    }


}
