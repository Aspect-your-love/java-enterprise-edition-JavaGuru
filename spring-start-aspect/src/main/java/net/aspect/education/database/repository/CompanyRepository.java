package net.aspect.education.database.repository;

import net.aspect.education.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository
        extends
        JpaRepository<Company, Integer> {

    List<Company> findAll();


    @Query("select c " +
           "from Company c " +
           "join fetch c.locales cl " +
           "where c.name = :name ")
    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String nameFragment);
}
