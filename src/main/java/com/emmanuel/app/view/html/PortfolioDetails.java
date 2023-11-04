package com.emmanuel.app.view.html;

import com.emmanuel.app.view.css.PortfolioDetailsCss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by emmanuel on 11/4/23
 *
 * @author: emmanuel
 * @date: 11/4/23
 * @project: IntelliJ IDEA
 */
public class PortfolioDetails {

        public void renderHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
            HttpSession session = request.getSession();
            PrintWriter print = response.getWriter();

            print.write("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                    "    <title>Portfolio Details - Investment App</title>" +
                    new PortfolioDetailsCss().getStyle() +
                    "</head>" +
                    "<body>" +
                    "<div class=\"header\">" +
                    "    <h1>Welcome Back, " + session.getAttribute("username") + "!</h1>" +
                    "    <h2>Your login time is: " + session.getAttribute("loggedInId") + "!</h2>" +
                    "</div>" +
                    "<div class=\"portfolio-details\">" +
                    "    <h2>Portfolio Details</h2>" +
                    "    <p>Portfolio Name: Your Portfolio Name</p>" +
                    "    <p>Investment Horizon: 5 years</p>" +
                    "    <p>Expected ROI: 20%</p>" +
                    "    <p>Investments: Investment 1, Investment 2</p>" +
                    "    <form action=\"analyze-risk\" method=\"post\">" +
                    "        <button class=\"analyze-risk-button\" type=\"submit\">Analyze Risk</button>" +
                    "    </form>" +
                    "    <form action=\"add-investment\" method=\"post\">" +
                    "        <button class=\"add-investment-button\" type=\"submit\">Add Investment</button>" +
                    "    </form>" +
                    "</div>" +
                    "</body>" +
                    "</html>");


        }

    }
