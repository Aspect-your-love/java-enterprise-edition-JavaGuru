package net.aspect.education.hibernate.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);

}
