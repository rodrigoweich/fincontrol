package io.github.rodrigoweich.fincontrolapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.github.rodrigoweich.fincontrolapi.entity.User;
import io.github.rodrigoweich.fincontrolapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findByNameContainingIgnoreCase(String lastname) {
        return userRepository.findByNameContainingIgnoreCase(lastname);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Page<User> list(
            Integer page,
            Integer size
    ) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageRequest);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> update(Long id, User user) {
        return userRepository.findById(id).map(user1 -> {
            user1.setName(user.getName());
            return userRepository.save(user1);
        });
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
