package com.emmanuel.app.action;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.database.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/portfolio-details/*")
public class PortfolioDetails extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String portfolioIdParam = req.getParameter("portfolioId");
        try {
            Long portfolioId = Long.parseLong(portfolioIdParam);

            Database database = Database.getDbInstance();
            Portfolio selectedPortfolio = database.findPortfolioById(portfolioId);

            if (selectedPortfolio != null) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("selectedPortfolio", selectedPortfolio);
                System.out.println(">>>>>Entered here");
                req.getRequestDispatcher("/PortfolioDetails.jsp").forward(req, resp);
                return;
            }
        } catch (NumberFormatException e) {
        }
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid or missing portfolio ID");
    }
}
