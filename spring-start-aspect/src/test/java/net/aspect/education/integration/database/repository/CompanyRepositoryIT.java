package net.aspect.education.integration.database.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import net.aspect.education.annotation.IT;
import net.aspect.education.database.entity.Company;
import net.aspect.education.database.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
class CompanyRepositoryIT {

    private static final Integer GO_GO_ID = 6;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyRepositoryIT(EntityManager entityManager, CompanyRepository companyRepository) {
        this.entityManager = entityManager;
        this.companyRepository = companyRepository;
    }

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);

        System.out.println(company);

        assertAll(
                () -> assertNotNull(company)
                , () -> assertThat(company.getLocales()).hasSize(1)
        );
    }

    @Test
    @Transactional
    public void deleteCompany() {
        Optional<Company> byId = companyRepository.findById(GO_GO_ID);
        assertTrue(byId.isPresent());

        byId.ifPresent(companyRepository::delete);

        // flush для того, чтобы увидеть SQL.
        entityManager.flush();

        entityManager.getDelegate();

        assertTrue(companyRepository.findById(GO_GO_ID).isEmpty());
    }

    @Test
    @Transactional
    public void findAllCompanyByFragmentNameIgnoreCase(){
        List<Company> proCom = companyRepository.findAllByNameContainingIgnoreCase("PRO");
        List<Company> yaCom = companyRepository.findAllByNameContainingIgnoreCase("ya");


        assertAll(
                () -> assertThat(proCom).isNotEmpty(),
                () -> assertThat(yaCom).isNotEmpty(),
                () -> assertThat(proCom
                        .stream()
                        .map(com -> com.getName())
                        .toList()).contains("Proton"),
                () -> assertThat(yaCom
                        .stream()
                        .map(com -> com.getName())
                        .toList()).containsAnyOf("Yandex", "Yandex-Taxi")
        );
    }

    @Test
    @Transactional
    void checkFindByQueries(){
        Optional<Company> yandex = companyRepository.findByName("Yandex");

        yandex.ifPresent(c -> System.out.println(c));
    }

}