package net.aspect.education.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aspect.education.UserDTO;
import net.aspect.education.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<UserDTO> user = userService.getUser(1L);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<h1> Пользователь: </h1>");
        writer.write("<h2>" + user.get().getName() + "</h2>");
        writer.write("</html></body>");
    }
}
