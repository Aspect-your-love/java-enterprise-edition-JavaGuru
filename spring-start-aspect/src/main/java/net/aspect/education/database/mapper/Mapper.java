package net.aspect.education.database.mapper;

public interface Mapper <E, D>{
    D map(E entity);

    default D map(E fromObject, D toObject){
        return toObject;
    }
}
