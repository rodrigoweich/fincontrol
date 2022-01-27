package io.github.rodrigoweich.fincontrolapi.model.entity.api.rest;

import io.github.rodrigoweich.fincontrolapi.model.entity.Movement;
import io.github.rodrigoweich.fincontrolapi.model.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
