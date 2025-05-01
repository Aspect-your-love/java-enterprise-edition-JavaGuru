package net.aspect.education.integration.database.repository;

import net.aspect.education.annotation.IT;
import net.aspect.education.database.dto.PersonalInfoDto;
import net.aspect.education.database.entity.Role;
import net.aspect.education.database.entity.User;
import net.aspect.education.database.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@Transactional
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void findByNameAndLastnameUseLike(){
        List<User> usList = userRepository.findAllByFirstnameContainingAndLastnameContaining("Iv", "Bu");

        System.out.println(usList);

        assertThat(usList).hasSize(2);
    }

    @Test
    void testUpdateRoleMoreUsers(){
        int result = userRepository.updateRole(Role.ADMIN, 1L, 2L, 3L);
        assertEquals(3, result);
    }

    @Test
    void testProjections(){
        List<PersonalInfoDto> allByCompanyId = userRepository.findAllByCompanyId(2);

        allByCompanyId.forEach(System.out::println);
        assertEquals(2, allByCompanyId.size());
    }

    @Test
    void testOrderBy(){
        Optional<User> t = userRepository.findFirstByCompanyIsNotNullOrderByIdDesc();

        assertTrue(t.isPresent());

        assertEquals("Marina", t.get().getFirstname());
    }

    @Test
    void testPageable(){
        Pageable pageable = PageRequest.of(1, 5, Sort.by("id"));
        List<User> allBy = userRepository.findAllBy(pageable);


        assertFalse(allBy.isEmpty());
        assertEquals(5, allBy.size());
    }
}