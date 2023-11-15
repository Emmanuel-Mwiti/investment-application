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