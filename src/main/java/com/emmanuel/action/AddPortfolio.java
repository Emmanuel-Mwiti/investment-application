package com.emmanuel.action;

import com.emmanuel.app.model.Portfolio;
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
 * Created by emmanuel on 11/4/23
 *
 * @author: emmanuel
 * @date: 11/4/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/add-portfolio")
public class AddPortfolio extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
            new com.emmanuel.app.view.html.AddPortfolio().renderHtml(req, resp);

        } else
            resp.sendRedirect("./");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
            Database dbInstance = Database.getDbInstance();
            String portfolioName = req.getParameter("portfolioName");
            String investmentHorizonStr = req.getParameter("investmentHorizon");
            String expectedROIStr = req.getParameter("expectedROI");
            dbInstance.getPortfolios().add(
                    new Portfolio(1L, portfolioName, Long.parseLong(investmentHorizonStr), Double.parseDouble(expectedROIStr))
            );
            resp.sendRedirect("./home");

        } else
            resp.sendRedirect("./");
    }

}
