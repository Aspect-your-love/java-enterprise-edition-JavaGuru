package net.aspect.education.servletapplicationedu.mapper;

public interface Mapper <T, F>{
    T mapFrom(F dto);
}
