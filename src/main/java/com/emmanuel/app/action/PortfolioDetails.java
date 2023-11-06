package com.emmanuel.app.action;

import com.emmanuel.app.view.html.PortfolioDetailsPage;
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

            new PortfolioDetailsPage().renderHtml(req,resp);


    }
}
