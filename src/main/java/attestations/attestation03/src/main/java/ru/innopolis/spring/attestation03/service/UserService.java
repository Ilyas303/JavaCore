package ru.innopolis.spring.attestation03.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.spring.attestation03.model.User;
import ru.innopolis.spring.attestation03.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}