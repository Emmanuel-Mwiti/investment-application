<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Portfolio</title>
    <link rel="stylesheet" type="text/css" href="Styles/Add_portfolio.css">
</head>
<body>
<div class="form-container">
    <form action="./add-portfolio" method="POST" id="portfolioForm">
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

        <button type="submit">Add Portfolio</button>
    </form>
</div>

</body>
</html>
