package io.github.rodrigoweich.fincontrolapi.http.controller;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;
import io.github.rodrigoweich.fincontrolapi.repository.MovementRepository;
import io.github.rodrigoweich.fincontrolapi.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movements")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovementController {

    private final MovementService movementService;

    @GetMapping("/date")
    public List<Movement> findByCreatedAtBetween(
            @RequestParam String start,
            @RequestParam String end
    ) {
        return movementService.findByCreatedAtBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping
    public Page<Movement> list (
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return movementService.list(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movement save(@RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Movement movement) {
        movementService.findMovementById(id).map(oldMovement -> {
            movementService.update(id, movement);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movement not found."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        movementService.findMovementById(id).map(movement -> {
            movementService.delete(movement.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movement not found."));
    }

}
