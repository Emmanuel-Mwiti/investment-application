package com.emmanuel.app.action;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.bean.impl.PortfolioBeanImpl;
import com.emmanuel.app.model.entity.Portfolio;
import com.emmanuel.app.view.html.AddPortfolioPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.CSS;
import java.io.IOException;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * Created by emmanuel on 11/4/23
 *
 * @author: emmanuel
 * @date: 11/4/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/add-portfolio")
public class AddPortfolio extends BaseAction {
    Portfolio portfolio = new Portfolio();
    PortfolioBeanI portfolioBean = new PortfolioBeanImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


        new AddPortfolioPage().renderHtml(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
//     getAttribute("selectedPortfolio");

        serializeForm(portfolio,req.getParameterMap());
        portfolioBean.addPortfolio(portfolio);
        resp.sendRedirect("./home");
    }

}
