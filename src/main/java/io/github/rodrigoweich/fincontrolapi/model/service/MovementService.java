package io.github.rodrigoweich.fincontrolapi.model.service;

import io.github.rodrigoweich.fincontrolapi.model.entity.Movement;
import io.github.rodrigoweich.fincontrolapi.model.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository movementRepository;

    public Optional<Movement> findMovementById(Long id) {
        return movementRepository.findById(id);
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

    public Optional<Movement> update(Long id, Movement movement) {
        return movementRepository.findById(id).map(movement1 -> {
            movement1.setMovement(movement.getMovement());
            return movementRepository.save(movement1);
        });
    }

    public void delete(Long id) {
        movementRepository.deleteById(id);
    }

}
