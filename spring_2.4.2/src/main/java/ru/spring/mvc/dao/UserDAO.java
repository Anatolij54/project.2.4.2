package ru.spring.mvc.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.mvc.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Component
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        TypedQuery<User> getPeople = entityManager.createQuery(
                "SELECT us FROM User us", User.class);
        return getPeople.getResultList();
    }

    public User show(Long id) {
        TypedQuery<User> getPeople = entityManager.createQuery(
                "SELECT us FROM User us WHERE us.id =: personid", User.class);
        getPeople.setParameter("personid", id);
        return getPeople.getSingleResult();
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(Long id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setPassword(updatedUser.getPassword());
        entityManager.merge(userToBeUpdated);
    }

    @Transactional
    public void delete(Long id) {
        User userToBeDeleted = show(id);
        entityManager.remove(userToBeDeleted);
    }
}
