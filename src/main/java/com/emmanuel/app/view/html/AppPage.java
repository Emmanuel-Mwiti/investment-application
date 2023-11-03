package com.emmanuel.app.view.html;

import com.emmanuel.app.view.css.AppCss;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Created by emmanuel on 11/3/23
 *
 * @author: emmanuel
 * @date: 11/3/23
 * @project: IntelliJ IDEA
 */
public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest request, HttpServletResponse response, String content) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();

        PrintWriter print = response.getWriter();

        print.write("<!DOCTYPE html>");
        print.write("<html lang=\"en\">");
        print.write("<head>");
        print.write("    <meta charset=\"UTF-8\">");
        print.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        print.write("    <title>Investment App Homepage</title>");
        print.write(new AppCss().getStyle());
        print.write("</head>");
        print.write("<body>");
        print.write("<div class=\"header\">");
        print.write("    <h1>Welcome Back, " + servletContext.getAttribute("username") + "!</h1>");
        print.write("    <p>Logged in at (dynamic log time and date)</p>");
        print.write("</div>");
        print.write("<div class=\"welcome\">");
        print.write("    <p>This is your Portfolios dashboard.</p>");
        print.write("</div>");
        print.write("<table>");
        print.write("    <tr>");
        print.write("        <th>Portfolio Name</th>");
        print.write("        <th>Investment Horizon</th>");
        print.write("        <th>Expected ROI</th>");
        print.write("        <th></th>");
        print.write("    </tr>");
        print.write(content);
        print.write("</table>");
        print.write("</body>");
        print.write("</html>");
    }
}
