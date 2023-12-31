package com.emmanuel.app.action;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.bean.PortfolioBean;
import com.emmanuel.app.view.html.AppPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PortfolioBeanI portfolioBean = new PortfolioBean();
        HttpSession session = req.getSession();

        new AppPage().renderHtml(req, resp,
                "<h2>Portfolios</h2>" +
                        portfolioBean.portfolios(), 0);

    }
}
