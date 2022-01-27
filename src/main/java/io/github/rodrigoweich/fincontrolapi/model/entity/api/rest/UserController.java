package io.github.rodrigoweich.fincontrolapi.model.entity.api.rest;

import io.github.rodrigoweich.fincontrolapi.model.entity.User;
import io.github.rodrigoweich.fincontrolapi.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<User> list (
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return userService.list(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

//    @PutMapping("{id}")
//    public User update(@PathVariable Integer id, @RequestBody User user) {
//        return userRepository.findById(id).map(data -> {
//            data.setName(user.getName());
//            data.setSuperUser(user.getSuperUser());
//            return userRepository.save(data);
//        });
//    }
}
