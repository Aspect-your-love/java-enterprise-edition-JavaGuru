package net.aspect.education.servletapplicationedu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post-aspect")
public class PostServletExample extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println(String.format("<h3>%s</h3>", req.getParameter("login")));
        writer.println(String.format("<h3>%s</h3>", req.getParameter("pwd")));
        writer.println("</body></html>");
        //По приколу указал URL вк
        resp.sendRedirect("https://www.vk.com");
    }
}
