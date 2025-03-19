package com.example.coffeeshop.repository;

import com.example.coffeeshop.model.Coffee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
public class CoffeeHibernateRepository implements CoffeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Coffee save(Coffee coffee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(coffee);
        return coffee;
    }

    @Override
    public Optional<Coffee> findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Coffee coffee = session.get(Coffee.class, id);
        return Optional.ofNullable(coffee);
    }

    @Override
    public Page<Coffee> findAll(Pageable pageable) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("FROM Coffee", Coffee.class);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        List<Coffee> coffees = query.getResultList();

        Query countQuery = session.createQuery("SELECT count(c.id) FROM Coffee c");
        Long total = (Long) countQuery.getSingleResult();

        return new PageImpl<>(coffees, pageable, total);
    }
}

