package attestations.attestation1;

import attestations.attestation01.model.User;
import attestations.attestation01.repository.UsersRepository;
import attestations.attestation01.repository.impl.UsersRepositoryFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class Usertest {
    private UsersRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UsersRepositoryFileImpl();
        repository.deleteAll();
    }

    @Test
    void testCreateAndFindById() {
        User user = new User("noisemc_99", "789ghs", "789ghs", "Крылов", "Виктор", "Павлович", 25, true);
        repository.create(user);

        User foundUser = repository.findById(user.getId());
        assertEquals(user, foundUser);
    }

    @Test
    void testUpdateUser() {
        User user = new User("noisemc_99", "789ghs", "789ghs", "Крылов", "Виктор", "Павлович", 25, true);
        repository.create(user);

        user.setAge(30);
        repository.update(user);

        User updatedUser = repository.findById(user.getId());
        assertEquals(30, updatedUser.getAge());
    }


    @Test
    void testDeleteAll() {
        User user = new User("noisemc_99", "789ghs", "789ghs", "Крылов", "Виктор", "Павлович", 25, true);
        repository.create(user);

        repository.deleteAll();
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void testFindByIdThrowsException() {

        assertThrows(NoSuchElementException.class, () -> repository.findById("non-existent-id"));
    }
}

