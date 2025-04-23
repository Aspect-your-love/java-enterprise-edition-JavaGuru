package net.aspect.education.hibernate.repository;

import jakarta.persistence.EntityManager;
import lombok.Cleanup;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.aspect.education.hibernate.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Класс реализующий базовые методы для любого репозитория
 */
@RequiredArgsConstructor
public class BaseRepository<K extends Serializable, E extends BaseEntity<K>> implements Repository<K, E> {

    private final Class<E> clazz;
    @Getter
    private final EntityManager entityManager;

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        entityManager.remove(entityManager.find(clazz, id));
        // Операция удаления обычно `отложенная`,
        // поэтому мы можем сразу вызвать flush()
        entityManager.flush();
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        // Получаем объект Criteria для получения сущностей списком
        var criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return entityManager.createQuery(criteria).getResultList();
    }
}
