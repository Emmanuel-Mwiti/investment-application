<%--
  Created by IntelliJ IDEA.
  User: emmanuel
  Date: 11/13/23
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Investment</title>
</head>
<body>
<div>
    <h2>Add Investment</h2>
    <form action="./add-investment" method="POST" id="investmentForm">
        <div>
            <label for="investmentCategory">Investment Category:</label>
            <select id="investmentCategory" name="investmentCategory" required>
                <option value="STOCKS">Stocks</option>
                <option value="BONDS">Bonds</option>
                <option value="MONEY_MARKET">Money Market</option>
                <option value="REAL_ESTATE">Real Estate</option>
                <option value="COMMODITIES">Commodities</option>
            </select>
        </div>

        <div>
            <label for="initialInvestment">Initial Investment Amount:</label>
            <input type="text" id="initialInvestment" name="initialInvestment" required>
        </div>

        <div>
            <label for="targetAllocation">Target Allocation Percentage:</label>
            <input type="text" id="targetAllocation" name="targetAllocation" required>
        </div>

        <div>
            <label for="finalAmount">Final Amount:</label>
            <input type="text" id="finalAmount" name="finalAmount" required>
        </div>

        <button type="submit">Add Investment</button>
    </form>
</div>
</body>
</html>
