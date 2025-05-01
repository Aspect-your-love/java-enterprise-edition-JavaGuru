package net.aspect.education.service;


import net.aspect.education.database.dto.CompanyReadDto;
import net.aspect.education.database.repository.CompanyRepository;
import net.aspect.education.listener.AccessType;
import net.aspect.education.listener.EntityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CompanyService( CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id).map(e -> {
            applicationEventPublisher.publishEvent(new EntityEvent(e, AccessType.READ));
            return new CompanyReadDto(e.getId());
        });
    }
}
