package io.github.rodrigoweich.fincontrolapi.service;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;
import io.github.rodrigoweich.fincontrolapi.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository movementRepository;

    public Optional<Movement> findMovementById(Long id) {
        return movementRepository.findById(id);
    }

    public List<Movement> findByCreatedAtBetween(LocalDate start, LocalDate end){
        return movementRepository.findByCreatedAtBetween(start, end);
    }

    public Page<Movement> list(
            Integer page,
            Integer size
    ) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return movementRepository.findAll(pageRequest);
    }

    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    public void deleteById(Long id) {
        movementRepository.deleteById(id);
    }

}
