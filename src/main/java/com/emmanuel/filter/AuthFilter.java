package com.emmanuel.filter;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by emmanuel on 11/6/23
 *
 * @author: emmanuel
 * @date: 11/6/23
 * @project: IntelliJ IDEA
 */
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();
        System.out.println("servlet path: " + servletPath);
        System.out.println("context path: " + httpRequest.getContextPath());
        System.out.println("context URI: " + httpRequest.getRequestURI());

            if (httpSession.isNew()) {
                System.out.println("1.New Session");
                httpSession.invalidate();

                if (servletPath.equals("/login") || servletPath.equals("/index.html")) {
                    System.out.println("2. Proceed to login...or index.html");
                    chain.doFilter(request, response);

                } else {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                    response.getWriter().flush();

                }

            } else {
                if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
                    httpResponse.addHeader("AuthTime", DateFormat.getDateTimeInstance().format(new Date()));
                    chain.doFilter(request, response);
                } else {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                    response.getWriter().flush();

                }
            }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
