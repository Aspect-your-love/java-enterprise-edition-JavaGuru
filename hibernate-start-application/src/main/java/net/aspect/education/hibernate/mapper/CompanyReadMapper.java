package net.aspect.education.hibernate.mapper;

import net.aspect.education.hibernate.dto.CompanyReadDto;
import net.aspect.education.hibernate.entity.Company;

public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{
    @Override
    public CompanyReadDto mapFrom(Company com) {
        return new CompanyReadDto(com.getId(), com.getName());
    }
}
