package net.aspect.education.hibernate.repository;

import jakarta.persistence.EntityManager;
import net.aspect.education.hibernate.entity.Company;
import net.aspect.education.hibernate.entity.Payment;

import java.util.List;

public class CompanyRepository extends BaseRepository<Long, Company>{
    public CompanyRepository(EntityManager entityManager) {
        super(Company.class, entityManager);
    }


}
