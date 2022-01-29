package io.github.rodrigoweich.fincontrolapi.http.controller;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;
import io.github.rodrigoweich.fincontrolapi.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovementController {

    private final MovementRepository movementRepository;

    @GetMapping
    public Page<Movement> list (
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return movementRepository.findAll(pageRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movement save(@RequestBody Movement movement) {
        return movementRepository.save(movement);
    }

    @GetMapping("/date")
    public List<Movement> findAllByRegDateBetween(@RequestParam String start, @RequestParam String end) {
        return movementRepository.findAllByRegDateBetween(start, end);
    }
}
