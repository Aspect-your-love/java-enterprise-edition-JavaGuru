package net.aspect.education.database.repository;


import net.aspect.education.database.dto.PersonalInfoDto;
import net.aspect.education.database.entity.Role;
import net.aspect.education.database.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u " +
           "where u.firstname like %:firstname% and u.lastname like %:lastname% ")
    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Query(
            value = "SELECT u.* FROM users AS u WHERE username = :username"
            , nativeQuery = true
    )
    public List<User> findAllByUsername(String username);

    @Query("update User u " +
           "set u.role = :role " +
           "where u.id in (:ids) ")
    @Modifying(clearAutomatically = true)
    public int updateRole(Role role, Long... ids);

    List<PersonalInfoDto> findAllByCompanyId(Integer id);

    Optional<User> findFirstByCompanyIsNotNullOrderByIdDesc();

    List<User> findFirst3By(Sort sort);

    List<User> findAllBy(Pageable pageable);
}
