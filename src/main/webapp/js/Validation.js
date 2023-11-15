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
