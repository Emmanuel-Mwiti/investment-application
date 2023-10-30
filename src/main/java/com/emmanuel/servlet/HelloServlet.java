package com.emmanuel.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by emmanuel on 10/30/23
 *
 * @author: emmanuel
 * @date: 10/30/23
 * @project: IntelliJ IDEA
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Initializing servlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println("<b>Hello this is my first servlet</b>");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying servlet");
    }
}
