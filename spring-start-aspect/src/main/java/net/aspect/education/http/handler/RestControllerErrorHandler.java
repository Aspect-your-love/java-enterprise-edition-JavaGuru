package net.aspect.education.http.handler;


import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "net.aspect.education.http.rest")
public class RestControllerErrorHandler extends ResponseEntityExceptionHandler {

}
