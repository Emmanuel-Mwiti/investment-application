package com.emmanuel.app.action;

import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.view.html.PortfolioDetailsPage;
import com.emmanuel.database.Database;
import org.apache.commons.lang.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by emmanuel on 11/3/23
 *
 * @author: emmanuel
 * @date: 11/3/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/portfolio-details")
public class PortfolioDetails extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Long portfolioId = null;

        String portfolioIdParam = req.getParameter("portfolioId");
        if (portfolioIdParam != null) {
            try {
                portfolioId = Long.parseLong(portfolioIdParam);
            } catch (NumberFormatException e) {

            }
        } else {
            System.out.println("The property ID is null!");
        }

        if (portfolioId != null) {
            Database database = Database.getDbInstance();
            Portfolio selectedPortfolio = database.findPortfolioById(portfolioId);
            httpSession.setAttribute("selectedPortfolio", selectedPortfolio);
        }else {
            System.out.println("The property ID is null!");
        }

        new PortfolioDetailsPage().renderHtml(req, resp);
    }

}
