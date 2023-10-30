<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Investment App Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
                    <form id="loginForm">
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
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/js/bootstrap.min.js"></script>

<script>
    // Client-side validation
    $(document).ready(function() {
        $("#loginForm").submit(function(e) {
            e.preventDefault();
            var username = $("#username").val();
            var password = $("#password").val();

            // Basic email validation
            if (!isValidEmail(username) && !isValidUsername(username)) {
                alert("Please enter a valid email or username.");
                return;
            }

            // Basic password validation (you can add more rules)
            if (password.length < 8) {
                alert("Password must be at least 8 characters long.");
                return;
            }

            // If validations pass, you can submit the form to your server for further processing.
            // Example: $.post("/login", { username: username, password: password }, function(data) { /* Handle the response */ });
        });

        // Function to check if the input is a valid email
        function isValidEmail(email) {
            var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailRegex.test(email);
        }

        // Function to check if the input is a valid username
        function isValidUsername(username) {
            // You can define your own rules for valid usernames
            // For example, only allow alphanumeric characters.
            var usernameRegex = /^[a-zA-Z0-9]+$/;
            return usernameRegex.test(username);
        }
    });
</script>
</body>
</html>