package io.github.rodrigoweich.fincontrolapi.repository;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}
