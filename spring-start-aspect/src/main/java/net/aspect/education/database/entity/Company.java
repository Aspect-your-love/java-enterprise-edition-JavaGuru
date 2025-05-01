package net.aspect.education.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /*
     * Мапинг сущности One to One
     * Вместо указания типа связи создаём
     * Map*/
    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "company_locales", joinColumns = @JoinColumn(name="company_id"))
    @MapKeyColumn(name="lang")
    @Column(name="description")
    private Map<String, String> locales = new HashMap<>();
}



