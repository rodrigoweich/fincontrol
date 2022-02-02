package io.github.rodrigoweich.fincontrolapi.repository;

import io.github.rodrigoweich.fincontrolapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContainingIgnoreCase(String name);

}
