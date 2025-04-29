package net.aspect.education.integer.service;

import lombok.RequiredArgsConstructor;
import net.aspect.education.CompanyService;
import net.aspect.education.annotation.IT;
import net.aspect.education.config.DataBasePropertiesYML;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyRecordServiceIT {
    private static final Long COMPANY_ID = 1L;

    private final CompanyService companyService;
    private final DataBasePropertiesYML dataBaseProperties;

    @Test
    void findById(){

    }
}
