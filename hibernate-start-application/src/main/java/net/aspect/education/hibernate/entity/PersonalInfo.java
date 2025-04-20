package net.aspect.education.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.aspect.education.hibernate.converter.BirthdayConverter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Entity
@Table(name="users", schema="public")
public class PersonalInfo {
    @Column(name="first_name")
    private String firstname;
    private String lastname;
    @Convert(converter = BirthdayConverter.class)
    @Column(name="birth_date")
    private Birthday birthDate;
}
