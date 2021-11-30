package ru.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.spring.mvc.model.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
