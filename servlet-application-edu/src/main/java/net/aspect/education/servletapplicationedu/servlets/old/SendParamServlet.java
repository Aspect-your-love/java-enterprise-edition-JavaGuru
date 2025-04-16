package net.aspect.education.servletapplicationedu.servlets.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/web-param")
public class SendParamServlet extends HttpServlet {
    private final static String JSP_PATH = "/WEB-INF/jsp/%s";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> exampleData = List.of("Hello World", "Misha", "Niko", "Karen");
        /* Устанавливаем атрибут для нашего JSP*/
        req.setAttribute("exampleData", exampleData);

        req.getRequestDispatcher(JSP_PATH.formatted("list-view-example.jsp")).forward(req, resp);
    }
}
