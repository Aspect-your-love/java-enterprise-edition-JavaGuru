package net.aspect.education.servletapplicationedu.servlets.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aspect.education.servletapplicationedu.dao.EmployeeDao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/all-employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        EmployeeDao employeeDAO = new EmployeeDao();

        req.setAttribute("employees", employeeDAO.getEmployees());

        req.getRequestDispatcher("WEB-INF/jsp/view-employee.jsp").forward(req, resp);
    }
}
