package com.workshop.bouali;

import com.workshop.bouali.domain.Role;
import com.workshop.bouali.domain.User;
import com.workshop.bouali.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BoualiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoualiApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Farhad Gadirli", "farhad", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Togrul Jafarov", "togrul", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Abdurrahman Gadirli", "abdu", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Ilyas Alizada", "ilyas", "1234", new ArrayList<>()));

            userService.addRoleToUser("farhad", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("farhad", "ROLE_ADMIN");
            userService.addRoleToUser("togrul", "ROLE_MANAGER");
            userService.addRoleToUser("ilyas", "ROLE_USER");
            userService.addRoleToUser("abdu", "ROLE_USER");
        };
    }

}
