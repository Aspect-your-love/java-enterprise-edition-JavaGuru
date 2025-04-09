package net.aspect.education.servletapplicationedu;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("INIT");
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setHeader("CUSTOM_HEADER", "aspect-cooper-study");

        //Получаем writer из Response
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Это ответ из сервлета FirstServlet</h1>");

        String header = req.getHeader("User-Agent");
        writer.println(String.format("Здесь должен быть заголовок." +
                " Поэтому данное поле указывает ваш User-agent: %s", header));
        //получаем имена всех заголовков
        Enumeration<String> headers = req.getHeaderNames();

        //пропускаем через цикл все заголовки и выводим на странице
        while(headers.hasMoreElements()){
            String s = headers.nextElement();
            writer.println(String.format("<h4>Headers name: %s <br> Headers content %s</h4>", s, req.getHeader(s)));
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
