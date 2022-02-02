package io.github.rodrigoweich.fincontrolapi.repository;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    List<Movement> findByCreatedAtBetween(LocalDate start, LocalDate end);

}
