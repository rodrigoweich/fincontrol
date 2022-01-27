package io.github.rodrigoweich.fincontrolapi.model.repository;

import io.github.rodrigoweich.fincontrolapi.model.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Integer> {
}
