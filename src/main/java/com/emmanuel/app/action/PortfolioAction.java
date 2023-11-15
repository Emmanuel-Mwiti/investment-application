package com.emmanuel.app.action;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.bean.impl.PortfolioBeanImpl;
import com.emmanuel.app.model.entity.Portfolio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
public class PortfolioAction extends BaseAction {

    PortfolioBeanI portfolioBean = new PortfolioBeanImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Portfolio_add.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();

        Portfolio portfolio = new Portfolio();
        portfolio.setId(portfolio.generateNextId());
//        httpSession.setAttribute("selectedPortfolio", portfolio);


        serializeForm(portfolio,req.getParameterMap());
        portfolioBean.addPortfolio(portfolio);
        resp.sendRedirect("./home");

    }

}
