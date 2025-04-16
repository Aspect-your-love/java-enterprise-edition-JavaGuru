package net.aspect.education.servletapplicationedu.servlets.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/cookies")
public class CookiesServlets  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

//        Arrays.stream(cookies).forEach(cookies -> );
        if (cookies == null ||
        Arrays.stream(cookies).filter(cookie-> "userId".equals(cookie.getName())).findAny().isEmpty()) {
            Cookie cookie = new Cookie("userId", "1");
            cookie.setMaxAge(60*60);
            cookie.setPath("/cookies");
            resp.addCookie(cookie);
        }
    }
}
