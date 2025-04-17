package net.aspect.education.servletapplicationedu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aspect.education.servletapplicationedu.dto.CreateUserDto;
import net.aspect.education.servletapplicationedu.utils.LocalDateFormatter;

import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final LocalDateFormatter formatter = LocalDateFormatter.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("ADMIN", "USER", "DIRECTOR"));
        req.setAttribute("genders", List.of("MALE", "FEMALE"));
        req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserDto userDto = new CreateUserDto(
                req.getParameter("name"),
                LocalDateFormatter.format(req.getParameter("birthday")).toString(),
                req.getParameter("email"),
                req.getParameter("pwd"),
                req.getParameter("role"),
                req.getParameter("gender")
        );
    }
}
