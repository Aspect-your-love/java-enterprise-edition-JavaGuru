package net.aspect.education.hibernate.entity;

//В версии 5 использовали пакет javax
import jakarta.persistence.*;
import lombok.*;
import net.aspect.education.hibernate.converter.BirthdayConverter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of={"username", "profile", "userChats"})
@ToString(exclude = "company")
@Entity
@Table(name="users", schema="public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Embedded
    private PersonalInfo personalInfo;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(optional = true, fetch=FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

    @OneToOne(mappedBy="user", cascade = CascadeType.ALL)
    private Profile profile;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UserChat> userChats = new ArrayList<>();
}