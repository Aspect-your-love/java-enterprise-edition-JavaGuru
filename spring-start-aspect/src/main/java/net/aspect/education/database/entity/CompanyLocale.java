package net.aspect.education.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="company_locales")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyLocale {
    @Id
    @Column(name="company_id")
    private Integer company_id;

    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Company company;

    @Column(name="lang", length = 2, nullable = false)
    private String lang;

    @Column(name="description")
    private String description;

    public void setCompany(Company company) {
        this.company = company;
        company_id = company.getId();
    }
}
