package com.emmanuel.app.action;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.bean.impl.PortfolioBeanImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by emmanuel on 11/15/23
 *
 * @author: emmanuel
 * @date: 11/15/23
 * @project: IntelliJ IDEA
 */
@WebServlet("/delete-portfolio")
    public class DeletePortfolioAction extends HttpServlet {

        private final PortfolioBeanI portfolioBean = new PortfolioBeanImpl();

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, IOException {
            String portfolioId = req.getParameter("portfolioId");
            portfolioBean.deletePortfolio(portfolioId);

            resp.sendRedirect("./home");
        }
    }


