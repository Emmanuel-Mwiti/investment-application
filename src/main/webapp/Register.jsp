<%--
    Created by IntelliJ IDEA.
    User: emmanuel
    Date: 11/9/23
    Time: 1:34 AM
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<%--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
    <link rel="stylesheet" href="#">
</head>
<body style="background-color: #f5f5f5;">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header" style="background-color: #007BFF; color: white;">
                    <h4>Create Your Investment Account</h4>
                </div>
                <div class="card-body">
                    <form id="signupForm" method="post" action="./sign-up">
                        <div class="form-group">
                            <label for="signupUsername">Email or Username</label>
                            <input type="text" class="form-control" id="signupUsername" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="signupPassword">Password</label>
                            <input type="password" class="form-control" id="signupPassword" name="password" required>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" required>
                        </div>
                        <div id="passwordMatchError" class="text-danger" style="display: none;">Passwords do not
                            match.
                        </div>
                        <div class="form-group">
                            <label for="investmentGoal">Investment Goal</label>
                            <input type="text" class="form-control" id="investmentGoal" name="investmentGoal" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block"
                                style="background-color: #007BFF; border: none;">Sign Up
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $('#signupForm').submit(function (e) {
            var signupPassword = $('#signupPassword').val();
            var confirmPassword = $('#confirmPassword').val();
            if (signupPassword !== confirmPassword) {
                $('#passwordMatchError').show();
                e.preventDefault();
            }
        });
    });
</script>
</html>
