<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.emmanuel.app.model.entity.Portfolio" %>
<%@ page import="com.emmanuel.app.model.entity.Investment" %>

<c:set var="portfolio" value="${sessionScope.selectedPortfolio}" />
<c:set var="investments" value="${portfolio.investments}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio Details - Investment App</title>
    <style>
        .portfolio-details {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f2f2f2;
            text-align: left;
        }

        .analyze-risk-button,
        .add-investment-button {
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            margin: 10px;
            cursor: pointer;
        }

        .analyze-risk-button:hover,
        .add-investment-button:hover {
            background-color: #0056b3;
        }

        .button-container {
            display: flex;
            justify-content: space-between;
        }

        .investment-table {
            margin-top: 20px;
        }

        .investment-table table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        .investment-table table, th, td {
            border: 1px solid #ddd;
        }

        .investment-table th, .investment-table td {
            padding: 10px;
            text-align: left;
        }
    </style>
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
        <form action="add-investment" method="post">
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
            <p>No investments in this portfolio.</p>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
