package net.aspect.education.hibernate.start.entity;

//В версии 5 использовали пакет javax
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.aspect.education.hibernate.start.converter.BirthdayConverter;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users", schema="public")
public class User {
    @Id
    private String username;
    @Column(name = "first_name")
    private String firstName;
    private String lastname;
    @Convert(converter = BirthdayConverter.class)
    @Column(name="birth_date")
    private Birthday birthDate;
    @Enumerated(EnumType.STRING)
    private Role role;
}