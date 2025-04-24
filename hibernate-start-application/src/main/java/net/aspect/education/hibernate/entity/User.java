package net.aspect.education.hibernate.entity;

//В версии 5 использовали пакет javax
import jakarta.persistence.*;
import lombok.*;
import net.aspect.education.hibernate.converter.BirthdayConverter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of={"username", "profile", "userChats"})
@ToString(exclude = {"company", "userChats", "payments"})
@Entity
@Table(name="users", schema="public")
@Inheritance(strategy = InheritanceType.JOINED)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseEntity<Long>{
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Embedded
    private PersonalInfo personalInfo;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    @OneToMany(mappedBy="receiver", fetch=FetchType.LAZY)
    private List<Payment> payments = new ArrayList<>();

    @ManyToOne(optional = true, fetch=FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

//    @OneToOne(mappedBy="user", cascade = CascadeType.ALL)
//    private Profile profile;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UserChat> userChats = new ArrayList<>();


}