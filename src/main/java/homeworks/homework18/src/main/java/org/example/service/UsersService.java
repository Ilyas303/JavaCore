package org.example.service;



import lombok.RequiredArgsConstructor;
import org.example.model.Users;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Users getUser(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
}
