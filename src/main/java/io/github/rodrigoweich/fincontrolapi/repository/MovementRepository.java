package io.github.rodrigoweich.fincontrolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    @Query(value = "SELECT * FROM MOVEMENTS WHERE CREATED_AT BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Movement> findAllByRegDateBetween(
            @Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate
    );

}
