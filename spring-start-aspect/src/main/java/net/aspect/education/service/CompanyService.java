package net.aspect.education.service;


import net.aspect.education.database.dto.CompanyReadDto;
import net.aspect.education.database.mapper.CompanyReadMapper;
import net.aspect.education.database.repository.CompanyRepository;
import net.aspect.education.listener.AccessType;
import net.aspect.education.listener.EntityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyReadMapper mapper;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher, CompanyReadMapper mapper) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.mapper = mapper;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id).map(e -> {
            applicationEventPublisher.publishEvent(new EntityEvent(e, AccessType.READ));
            return new CompanyReadDto(e.getId(), "UNDEFINED");
        });
    }

    public List<CompanyReadDto> findAll(){
        return companyRepository.findAll().stream().map(mapper::map).toList();
    }
}
