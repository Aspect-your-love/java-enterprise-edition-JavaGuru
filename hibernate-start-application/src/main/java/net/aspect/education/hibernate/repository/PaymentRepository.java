package net.aspect.education.hibernate.repository;

import jakarta.persistence.EntityManager;
import net.aspect.education.hibernate.entity.Payment;
import org.hibernate.SessionFactory;

import java.util.List;


public class PaymentRepository extends BaseRepository<Long, Payment>{
    public PaymentRepository(EntityManager entityManager) {
        super(Payment.class, entityManager);
    }

    public List<Payment> findAllByRecieverId(Long recieverId){
        return getEntityManager().createQuery("select p from Payment p where p.receiver.id = :receiverId", Payment.class)
                .setParameter("receiverId", recieverId).getResultList();
    }
}
