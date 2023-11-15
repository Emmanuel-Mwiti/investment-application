package com.emmanuel.app.action;

import com.emmanuel.app.model.entity.AssetClass;
import com.emmanuel.app.model.entity.Investment;
import com.emmanuel.app.model.entity.Portfolio;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addInvestment")
public class AddInvestment extends BaseAction {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        Portfolio selectedPortfolio = (Portfolio) httpSession.getAttribute("selectedPortfolio");

        if (selectedPortfolio == null) {
            System.out.println("Selected portfolio is null");
            resp.sendRedirect("home");
            return;
        }

        Investment newInvestment = new Investment();
        newInvestment.setAssetClass(AssetClass.valueOf(req.getParameter("investmentCategory")));
        newInvestment.setInitialInvestmentAmount(Double.parseDouble(req.getParameter("initialInvestment")));
        newInvestment.setTargetAllocation(Double.parseDouble(req.getParameter("targetAllocation")));
        newInvestment.setFinalAmount(Double.parseDouble(req.getParameter("finalAmount")));

        selectedPortfolio.getInvestments().add(newInvestment);

        httpSession.setAttribute("selectedPortfolio", selectedPortfolio);

        resp.sendRedirect("portfolio-details");
    }
}
