<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.emmanuel.app.model.entity.Portfolio" %>
<%@ page import="com.emmanuel.app.model.entity.Investment" %>

<%
    Portfolio portfolio = (Portfolio) session.getAttribute("selectedPortfolio");
    List<Investment> investments = portfolio.getInvestments();
    request.setAttribute("investments", investments);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio Details - Investment App</title>
    <link rel="stylesheet" type="text/css" href="Styles/Portfolio_Details.css">
</head>
<body>
<div class="portfolio-details">
    <h2>Portfolio Details</h2>
    <p>Portfolio Name: ${portfolio.name}</p>
    <p>Investment Horizon: ${portfolio.investmentHorizon} years</p>
    <p>Expected ROI: ${portfolio.expectedReturnOnInvestment}%</p>
    <div class="button-container">
        <form action="analyze-risk" method="post">
            <button class="analyze-risk-button" type="submit">Analyze Risk</button>
        </form>
        <form action="addInvestment" method="post">
            <label for="investmentType">Investment Type:</label>
            <select name="investmentCategory">
                <option value="STOCKS">Stocks</option>
                <option value="BONDS">Bonds</option>
                <option value="COMMODITIES">Commodities</option>
                <option value="MONEY_MARKET">Money Market</option>
                <option value="REAL_ESTATE">Real Estate</option>
            </select>
            <br>

            <label for="initialInvestment">Initial Investment:</label>
            <input type="text" name="initialInvestment" id="initialInvestment" required>

            <br>

            <label for="targetAllocation">Target Allocation:</label>
            <input type="text" name="targetAllocation" id="targetAllocation" required>

            <br>

            <label for="finalAmount">Final Amount:</label>
            <input type="text" name="finalAmount" id="finalAmount" required>
            <br>

            <button class="add-investment-button" type="submit">Add Investment</button>
        </form>
    </div>
</div>

<div class="investment-table">
    <h3>Investments:</h3>
    <c:choose>
        <c:when test="${not empty investments}">

            <table>
                <tr>
                    <th>Asset Class</th>
                    <th>Initial Amount</th>
                    <th>Target Allocation</th>
                    <th>Final Amount</th>
                </tr>
                <c:forEach var="investment" items="${investments}">
                    <tr>
                        <td>${investment.assetClass}</td>
                        <td>${investment.initialInvestmentAmount}</td>
                        <td>${investment.targetAllocation}</td>
                        <td>${investment.finalValue}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>No investments in this portfolio. You will need first to add the investments</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
