package edu.javacourse.third.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by antonsaburov on 25.05.17.
 */
public class SimpleFilter implements Filter
{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FILTER START");
        HttpServletRequest htr = (HttpServletRequest) req;
        resp.getWriter().append("Filter 1 before.");
        if(filterChain != null) {
            filterChain.doFilter(req, resp);
        }
        resp.getWriter().append("Filter 1 after.");
        System.out.println("FILTER FINISH");
    }

    public void destroy() {

    }
}
