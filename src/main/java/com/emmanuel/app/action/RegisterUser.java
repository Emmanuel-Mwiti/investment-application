package com.emmanuel.app.action;

import com.emmanuel.app.bean.UserBeanI;
import com.emmanuel.app.bean.impl.UserBeanImpl;
import com.emmanuel.app.model.User;
import com.emmanuel.database.Database;
import org.apache.commons.lang.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sign-up")
public class RegisterUser extends BaseAction {
    User user = new User();
    UserBeanI userBean = new UserBeanImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();

        serializeForm(user, req.getParameterMap());
        userBean.addUser(user);

        resp.sendRedirect("./");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        PrintWriter write = resp.getWriter();

        write.println("<!DOCTYPE html>");
        write.println("<html lang=\"en\">");
        write.println("<head>");
        write.println("    <meta charset=\"UTF-8\">");
        write.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        write.println("    <title>Investment App</title>");
        write.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        write.println("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>");
        write.println("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/js/bootstrap.min.js\"></script>");
        write.println("    <link rel=\"stylesheet\" href=\"#\">");
        write.println("</head>");
        write.println("<body style=\"background-color: #f5f5f5;\">");
        write.println("<div class=\"container\">");
        write.println("    <div class=\"row justify-content-center mt-5\">");
        write.println("        <div class=\"col-md-6\">");
        write.println("            <div class=\"card\">");
        write.println("                <div class=\"card-header\" style=\"background-color: #007BFF; color: white;\">");
        write.println("                    <h4>Create Your Investment Account</h4>");
        write.println("                </div>");
        write.println("                <div class=\"card-body\">");
        write.println("                    <form id=\"signupForm\" method=\"post\" action=\"./sign-up\">");
        write.println("                        <div class=\"form-group\">");
        write.println("                            <label for=\"signupUsername\">Email or Username</label>");
        write.println("                            <input type=\"text\" class=\"form-control\" id=\"signupUsername\" name=\"name\" required>");
        write.println("                        </div>");
        write.println("                        <div class=\"form-group\">");
        write.println("                            <label for=\"signupPassword\">Password</label>");
        write.println("                            <input type=\"password\" class=\"form-control\" id=\"signupPassword\" name=\"password\" required>");
        write.println("                        </div>");
        write.println("                        <div class=\"form-group\">");
        write.println("                            <label for=\"confirmPassword\">Confirm Password</label>");
        write.println("                            <input type=\"password\" class=\"form-control\" id=\"confirmPassword\" required>");
        write.println("                        </div>");
        write.println("                        <div id=\"passwordMatchError\" class=\"text-danger\" style=\"display: none;\">Passwords do not match.</div>");
        write.println("                        <div class=\"form-group\">");
        write.println("                            <label for=\"investmentGoal\">Investment Goal</label>");
        write.println("                            <input type=\"text\" class=\"form-control\" id=\"investmentGoal\" name=\"investmentGoal\" required>");
        write.println("                        </div>");
        write.println("                        <button type=\"submit\" class=\"btn btn-primary btn-block\" style=\"background-color: #007BFF; border: none;\">Sign Up</button>");
        write.println("                    </form>");
        write.println("                </div>");
        write.println("            </div>");
        write.println("        </div>");
        write.println("    </div>");
        write.println("</div>");
        write.println("</body>");
        write.println("<script>");
        write.println("    $(document).ready(function() {");
        write.println("        $('#signupForm').submit(function(e) {");
        write.println("            var signupPassword = $('#signupPassword').val();");
        write.println("            var confirmPassword = $('#confirmPassword').val();");
        write.println("            if (signupPassword !== confirmPassword) {");
        write.println("                $('#passwordMatchError').show();");
        write.println("            }");
        write.println("        });");
        write.println("    });");
        write.println("</script>");
        write.println("</html>");
    }
}
