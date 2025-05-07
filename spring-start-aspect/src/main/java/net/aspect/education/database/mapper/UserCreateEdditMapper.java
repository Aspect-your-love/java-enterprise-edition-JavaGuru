package net.aspect.education.database.mapper;

import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.database.entity.Company;
import net.aspect.education.database.entity.User;
import net.aspect.education.database.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserCreateEdditMapper implements Mapper<UserCreateEditDto, User> {


    private final CompanyRepository companyRepository;

    @Autowired
    public UserCreateEdditMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public User map(UserCreateEditDto fromObject, User toObject){
        setUserField(fromObject, toObject);
        return toObject;
    }


    @Override
    public User map(UserCreateEditDto dto) {
        User user = new User();
        setUserField(dto, user);
        return user;
    }

    private void setUserField(UserCreateEditDto dto, User user) {
        user.setUsername(dto.getUsername());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setBirthDay(dto.getBirthDate());
        user.setRole(dto.getRole());
        user.setCompany(getCompany(dto.getCompanyId()));

        Optional.ofNullable(dto.getImage())
                .filter(Predicate.not(MultipartFile::isEmpty))
                .ifPresent(image -> user.setImage(image.getOriginalFilename()));
    }

    private Company getCompany(Integer companyId) {
        return Optional
                .ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }
}
