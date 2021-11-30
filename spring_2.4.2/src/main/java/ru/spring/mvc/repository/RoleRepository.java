package ru.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.spring.mvc.model.Role;

@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {

}
