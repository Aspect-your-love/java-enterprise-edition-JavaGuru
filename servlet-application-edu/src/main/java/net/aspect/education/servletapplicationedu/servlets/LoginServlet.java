package net.aspect.education.servletapplicationedu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aspect.education.servletapplicationedu.dto.UserDto;
import net.aspect.education.servletapplicationedu.service.UserService;
import net.aspect.education.servletapplicationedu.utils.UrlPath;

import java.io.IOException;

@WebServlet(UrlPath.LOGIN)
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService
                .login(req.getParameter("email"), req.getParameter("pwd"))
                .ifPresentOrElse(userDto -> {
                            try {
                                onLoginSucces(userDto, req, resp);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                onLooginFall(req, resp);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
    }

    private void onLoginSucces(UserDto userDto, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("user", userDto);
        resp.sendRedirect("/all-employee");
    }

    private void onLooginFall(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
    }
}
