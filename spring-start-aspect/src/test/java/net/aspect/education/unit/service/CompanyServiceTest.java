package net.aspect.education.unit.service;

import net.aspect.education.database.dto.CompanyReadDto;
import net.aspect.education.database.entity.Company;
import net.aspect.education.database.repository.CompanyRepository;
import net.aspect.education.listener.EntityEvent;
import net.aspect.education.CompanyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Long COMPANY_ID = 1L;

    @Mock   //Устанавливаем заглушку
    private CompanyRepository companyRepository;
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @InjectMocks //Внедряем заглушки
    private CompanyService companyService;

    @Test
    @DisplayName("Поиск по идентификатору")
    void findById() {
        /*
        * Когда происходит вызов companyRepository,
        * просим у Mockito сделать подмену и вернуть
        * заглушку по ID*/
        Mockito.doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyRepository)
                .findById(COMPANY_ID);

        // Актуальный результат
        var actualResult = companyService.findById(COMPANY_ID);
        //Ожидаемый результат
        var expectedResult = new CompanyReadDto(COMPANY_ID);

        Mockito.verify(applicationEventPublisher).publishEvent(Mockito.any(EntityEvent.class));
        assertAll(
                () -> assertTrue(actualResult.isPresent()),
                () -> actualResult.ifPresent(actual -> assertEquals(expectedResult, actual))
        );
    }
}