package net.aspect.education.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@ToString(exclude = "receiver")
@Table(name = "payments")
public class Payment extends BaseEntity<Long> {

    @Column(nullable = false, name = "amount")
    private Integer amount;

    @Version
    private Long version;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;
}
