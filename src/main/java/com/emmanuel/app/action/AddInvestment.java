package com.emmanuel.app.action;

import com.emmanuel.app.model.entity.Investment;
import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.view.html.AddInvestmentPage;
import org.apache.commons.lang.StringUtils;

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
@WebServlet("/add-investment")
public class AddInvestment extends BaseAction {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        new AddInvestmentPage().renderHtml(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        Portfolio selectedPortfolio = (Portfolio) httpSession.getAttribute("selectedPortfolio");

        // Check if the selected portfolio is null
        if (selectedPortfolio == null) {
            System.out.println("selected portfolio is null");

            resp.sendRedirect("home");
            return;
        }
        Investment newInvestment = new Investment();
        serializeForm(newInvestment, req.getParameterMap());

        selectedPortfolio.getInvestments().add(newInvestment);

        httpSession.setAttribute("selectedPortfolio", selectedPortfolio);

        resp.sendRedirect("portfolio-details");
    }
}
