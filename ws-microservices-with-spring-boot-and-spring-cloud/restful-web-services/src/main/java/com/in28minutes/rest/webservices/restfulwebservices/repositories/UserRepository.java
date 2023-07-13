package com.in28minutes.rest.webservices.restfulwebservices.repositories;

import com.in28minutes.rest.webservices.restfulwebservices.entities.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    static {
        users.addAll(Arrays.asList(
                new User(1, "Adam", LocalDate.now().minusYears(30)),
                new User(2, "Eve", LocalDate.now().minusYears(25)),
                new User(3, "Jim", LocalDate.now().minusYears(20))
        ));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer id) {
        return users.stream().filter(user -> Objects.equals(user.getId(), id)).findFirst().orElse(null);
    }
}
