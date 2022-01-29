package io.github.rodrigoweich.fincontrolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.rodrigoweich.fincontrolapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM USERS WHERE NAME LIKE '%:lastname%'", nativeQuery = true)
    List<User> findByLastname(@Param("lastname") String lastname);
}
