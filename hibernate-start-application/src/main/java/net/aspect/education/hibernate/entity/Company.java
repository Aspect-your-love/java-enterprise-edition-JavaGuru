package net.aspect.education.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(exclude = "users")
@Builder
@Entity
@Table(name="company")
public class Company extends BaseEntity<Long>{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    //Указываем поле в mappedBy, которое сопоставляется
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    /**
     * Метод для добавления новых пользователей
     * в существующую компанию.*/
    public void addUser(User user){
        if (users == null)
            users = new HashSet<>();
        users.add(user);
        user.setCompany(this);
    }
}
