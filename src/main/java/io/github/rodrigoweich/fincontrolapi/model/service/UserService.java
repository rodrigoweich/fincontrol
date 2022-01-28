package io.github.rodrigoweich.fincontrolapi.model.service;

import io.github.rodrigoweich.fincontrolapi.model.entity.User;
import io.github.rodrigoweich.fincontrolapi.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<User> list(
            Integer page,
            Integer size
    ) {
        return userRepository.findAll(generatePageRequest(page,size));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    private PageRequest generatePageRequest(Integer page, Integer size){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return PageRequest.of(page, size, sort);
    }
}
