<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Investment App</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="#">
</head>
<body style="background-color: #f5f5f5;">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header" style="background-color: #007BFF; color: white;">
                    <h4><%= application.getInitParameter("AppName") %></h4>
                </div>
                <div class="card-body">
                    <form id="loginForm" method="post" action="./login">
                        <div class="form-group">
                            <label for="username">Email or Username</label>
                            <input type="text" class="form-control" id="username" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block"
                                style="background-color: #007BFF; border: none;">Login
                        </button>
                    </form>
                    <p class="mt-3">
                        <a href="#" style="color: #007BFF;">Forgot Password?</a>
                    </p>
                    <p>
                        Don't have an account? <a href="./Register.jsp" style="color: #007BFF;">Sign Up</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("#loginForm").submit(function (e) {
            const username = $("#username").val();
            const password = $("#password").val();

            if (!isValidEmail(username) && !isValidUsername(username)) {
                alert("Please enter a valid email or username.");
                e.preventDefault();
                return;
            }

            if (password.length < 4) {
                alert("Password must be at least 4 characters long.");
                e.preventDefault();
            }
        });

        function isValidEmail(email) {
            const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailRegex.test(email);
        }

        function isValidUsername(username) {
            const usernameRegex = /^[a-zA-Z0-9]+$/;
            return usernameRegex.test(username);
        }
    });
</script>
</body>
</html>
