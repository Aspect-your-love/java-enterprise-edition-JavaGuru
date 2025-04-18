package net.aspect.education.servletapplicationedu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter("/*") //- обработка абсолютно всех запросов
//@WebFilter("/registr") - только для сервлета '/registr'
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Установка стандартной кодировки для запроса
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        //Установка стандартной кодировки для ответа
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        //Дальнейшая передача запроса (можно передать
        //в другой фильтр).
        chain.doFilter(request, response);
    }
}


