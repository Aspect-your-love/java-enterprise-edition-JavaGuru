package net.aspect.education.database.mapper;

import net.aspect.education.database.dto.CompanyReadDto;
import net.aspect.education.database.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{
    @Override
    public CompanyReadDto map(Company entity) {
        return new CompanyReadDto(
                entity.getId(),
                entity.getName()
        );
    }
}
