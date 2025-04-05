package org.example.repository;


import org.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository  {
    Optional<Users> findById(Long id);
    List<Users> findAll();
}