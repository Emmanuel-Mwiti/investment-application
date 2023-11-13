<%--
  Created by IntelliJ IDEA.
  User: emmanuel
  Date: 11/13/23
  Time: 5:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Portfolio</title>
<%--    <%@ include file="Styles/Add_portfolio.css" %>--%>
    <link rel="stylesheet" type="text/css" href="Styles/Add_portfolio.css">
</head>
<body>
<div class="form-container">
    <form action="./add-portfolio" method="POST" class="#" id="portfolioForm">
        <div class="form-group">
            <label for="portfolioName" class="form-label">Portfolio Name:</label><br>
            <input type="text" id="portfolioName" name="name" class="form-input" required><br>
        </div>

        <div class="form-group">
            <label for="investmentHorizon" class="form-label">Investment Horizon:</label><br>
            <input type="text" id="investmentHorizon" name="investmentHorizon" class="form-input" required><br>
        </div>

        <div class="form-group">
            <label for="expectedReturn" class="form-label">Expected Return on Investment:</label><br>
            <input type="text" id="expectedReturn" name="expectedReturnOnInvestment" class="form-input" required><br>
        </div>

        <button type="button" onclick="addInvestmentEntry()">Add Investment</button>

        <div class="investment-list">
        </div>

        <input type="submit" value="Add Portfolio" class="form-button">
    </form>

    <script>
        function addInvestmentEntry() {
            var investmentList = document.querySelector('.investment-list');
            var newInvestmentEntry = document.createElement('div');
            newInvestmentEntry.innerHTML = `
                <div class="form-group">
                    <label for="investmentName" class="form-label">Investment Name:</label><br>
                    <input type="text" name="investmentName[]" class="form-input" required><br>
                </div>
                <div class="form-group">
                    <label for="investmentAmount" class="form-label">Investment Amount:</label><br>
                    <input type="text" name="investmentAmount[]" class="form-input" required><br>
                </div>
            `;
            investmentList.appendChild(newInvestmentEntry);
        }
    </script>
</div>
</body>
</html>
