package com.emmanuel.home;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.bean.impl.PortfolioBeanImpl;
import com.emmanuel.app.model.Portfolio;
import com.emmanuel.app.view.html.AppPage;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PortfolioBeanI portfolioBean = new PortfolioBeanImpl();
        HttpSession session = req.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            PrintWriter print = resp.getWriter();
            new AppPage().renderHtml(req, resp, portfolioBean.portfolios());
        } else {
            resp.sendRedirect("./");
        }


    }
}
