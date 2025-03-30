package org.example.repository;


import org.example.model.Users;
import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    Optional<Users> findById(Long id);
    List<Users> findAll();
}