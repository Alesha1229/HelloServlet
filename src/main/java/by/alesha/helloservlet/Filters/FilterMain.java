package by.alesha.helloservlet.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class FilterMain implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String firstValue = request.getServletContext() //
                .getInitParameter("first"); // параметр из context в web.xml
        System.out.println("My first value - " + firstValue);
        System.out.println("!!! Hello filter !!!");
        if (request.getParameter("name") == null){
            request.getRequestDispatcher("error.jsp")
                    .forward(request, response);
        } else {
            System.out.println("Hello, " + request.getParameter("name"));
            chain.doFilter(request,response);
        }
        chain.doFilter(request, response); // обязательная строкаб что бы фильтр передовался
    }
}
