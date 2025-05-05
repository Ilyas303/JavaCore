package ru.innopolis.spring.attestation03.repository;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.innopolis.spring.attestation03.model.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserByEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("password");
        user.setPhone("+1234567890");
        user.setDeleted(false);
        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail("test@example.com");


        assertTrue(found.isPresent(), "Пользователь должен быть найден");
        assertEquals("test@example.com", found.get().getEmail());
        assertFalse(found.get().isDeleted(), "Пользователь не должен быть удален");
    }
}