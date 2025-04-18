package net.aspect.education.servletapplicationedu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aspect.education.servletapplicationedu.utils.UrlPath;

import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private static final Set<String> PUBLIC_PATH = Set.of(UrlPath.LOGIN, UrlPath.REGISTRATION);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if(isPublicPath(requestURI) || isUserLoggedIn(servletRequest))
            filterChain.doFilter(servletRequest, servletResponse);
        else
            ((HttpServletResponse) servletResponse).sendRedirect(UrlPath.LOGIN);
    }

    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        Object user = ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String requestURI) {
        return PUBLIC_PATH.stream().anyMatch(e -> requestURI.startsWith(e));
    }
}
