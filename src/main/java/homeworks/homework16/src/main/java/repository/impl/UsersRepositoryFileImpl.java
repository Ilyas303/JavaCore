package repository.impl;

import model.User;
import repository.UsersRepository;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static final List<User> USERS = new ArrayList<>();
    private static final String FILE_PATH = "users.txt";

    @Override
    public void create(User user) {
        USERS.add(user);
        saveUsersToFile();
    }

    @Override
    public User findById(String id) {
        if (USERS.isEmpty()) {
            findAll();
        }

        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Пользователь не найден!"));
    }

    @Override
    public List<User> findAll() {
        if (USERS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
                List<User> usersFromFile = br.lines()
                        .map(this::parseUser)
                        .collect(Collectors.toList());

                USERS.addAll(usersFromFile);
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
                return Collections.emptyList();
            }
        }
        return USERS;
    }

    @Override
    public void update(User user) {
        User existingUser = findById(user.getId());
        USERS.remove(existingUser);
        USERS.add(user);
        saveUsersToFile();
    }

    @Override
    public void deleteById(String id) {
        User user = findById(id);
        USERS.remove(user);
        saveUsersToFile();
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        saveUsersToFile();
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : USERS) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private User parseUser(String line) {
        String[] parts = line.split("\\|");
        return new User(
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7],
                parts[8].isEmpty() ? null : Integer.parseInt(parts[8]),
                Boolean.parseBoolean(parts[9])
        );
    }
}