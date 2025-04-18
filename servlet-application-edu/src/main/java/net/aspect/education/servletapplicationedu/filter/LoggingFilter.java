package net.aspect.education.servletapplicationedu.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.Filter;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Фильтр "логирования". Принимает абсолютно все
 * параметры из запросов и выводит их в
 * консоль*/
@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request
            , ServletResponse response
            , FilterChain chain)
            throws IOException, ServletException {
        request
                .getParameterMap()
                .forEach((key, value)
                        -> System.out.println(key + ':'
                        + Arrays.toString(value)));
        chain.doFilter(request, response);
    }
}
