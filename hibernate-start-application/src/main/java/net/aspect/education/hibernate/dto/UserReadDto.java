package net.aspect.education.hibernate.dto;

import net.aspect.education.hibernate.entity.PersonalInfo;
import net.aspect.education.hibernate.entity.Role;

public record UserReadDto(Long id
        , PersonalInfo personalInfo
        , String userName
        , Role role
        , CompanyReadDto company
) {
}
