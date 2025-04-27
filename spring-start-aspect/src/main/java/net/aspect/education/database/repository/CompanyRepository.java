package net.aspect.education.database.repository;

import net.aspect.education.database.entity.Company;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository {
    public Optional<Company> findById(Long id){
        System.out.println("Company repo. Find By id");
        return Optional.of(new Company(id));
    }
}
