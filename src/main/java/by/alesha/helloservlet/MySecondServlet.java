package by.alesha.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

@WebServlet(value = "/hi/*")
public class MySecondServlet extends HttpServlet {

    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 100;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet path: " + req.getServletPath());
        System.out.println("Servlet URI: " + req.getRequestURI());

        System.out.println("Parameter: " + req.getParameter("my"));
        // http://localhost:8081/hi/abc?my=123&another=empty

        HttpSession session = req.getSession();
        Integer currentParam = (Integer) session.getAttribute("count");
        System.out.println("Current param: " + currentParam);
        if (currentParam == null) {
            currentParam = counter;
        }
        session.setAttribute("count", currentParam + 1);
        System.out.println("Headers: " + req.getHeaderNames());

        PrintWriter writer = resp.getWriter();
        writer.println("this is my second response" + ". Current param: " + currentParam);
        Iterator<String> headersIterator = req.getHeaderNames().asIterator();
        while (headersIterator.hasNext()) {
            writer.println("\nHeaders: " + headersIterator.next());
        }
        writer.println("\nHost: " + req.getHeader("host"));
        resp.setHeader("myHeader", "abra_cadabra");
        writer.println("\nCookies: " + Arrays.asList(req.getCookies())
                .stream()
                .map(cookie -> cookie.getName() + " " + cookie.getValue() + " " + cookie.getMaxAge())
                .collect(Collectors.toList()));
        resp.sendRedirect("/here"); // переадресация в другое место here
        if (currentParam > 105) {
            resp.sendRedirect("/here"); // переадресация в другое место here
            Person person = new Person();
            //resp.setStatus(500);
            //resp.sendError(500, "Too much");
        }
        writer.println("\nHeaders: " + req.getHeaderNames());
    }
}
