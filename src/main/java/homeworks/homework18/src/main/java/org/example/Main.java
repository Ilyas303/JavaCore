package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Users;
import org.example.service.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Main {

    private final UsersService usersService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void init() {
        try {
            Users user = usersService.getUser(15l);
            log.info("Пользователь: {}", user);
        } catch (Exception e) {
            log.error("Ошибка при получении пользователя: {}", e.getMessage());
        }
    }


}