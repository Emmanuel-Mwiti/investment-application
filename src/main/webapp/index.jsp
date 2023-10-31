<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Investment App Login</title>
    <!-- Load Bootstrap and jQuery libraries -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/js/bootstrap.min.js"></script>
    <!-- Add a link to your custom styles -->
    <link rel="stylesheet" href="#">
</head>
<body style="background-color: #f5f5f5;">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header" style="background-color: #007BFF; color: white;">
                    <h4>Login to Your Investment Account</h4>
                </div>
                <div class="card-body">
                    <form id="loginForm" method="post" action="./login">
                        <div class="form-group">
                            <label for="username">Email or Username</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block" style="background-color: #007BFF; border: none;">Login</button>
                    </form>
                    <p class="mt-3">
                        <a href="#" style="color: #007BFF;">Forgot Password?</a>
                    </p>
                    <p>
                        Don't have an account? <a href="#" style="color: #007BFF;">Sign Up</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#loginForm").submit(function(e) {
            var username = $("#username").val();
            var password = $("#password").val();

            if (!isValidEmail(username) && !isValidUsername(username)) {
                alert("Please enter a valid email or username.");
                return;
            }

            if (password.length < 4) {
                alert("Password must be at least 4 characters long.");
                return;
            }

            // If validations pass, you can submit the form to your server for further processing.
            // Example: $.post("/login", { username: username, password: password }, function(data) { /* Handle the response */ });
        });

        function isValidEmail(email) {
            var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailRegex.test(email);
        }

        function isValidUsername(username) {
            // Define your own rules for valid usernames if needed.
            // For example, only allow alphanumeric characters.
            var usernameRegex = /^[a-zA-Z0-9]+$/;
            return usernameRegex.test(username);
        }
    });
</script>
</body>
</html>
