package net.aspect.education.database.repository;

import net.aspect.education.database.entity.CompanyRecord;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository {
    public Optional<CompanyRecord> findById(Long id){
        System.out.println("CompanyRecord repo. Find By id");
        return Optional.of(new CompanyRecord(id));
    }
}
