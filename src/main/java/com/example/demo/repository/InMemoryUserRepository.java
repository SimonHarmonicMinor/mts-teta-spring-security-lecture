package com.example.demo.repository;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserRepository implements UserRepository {

  private static final Map<Long, User> USERS = Stream.of(
          new User(1L, "admin", "admin", Role.ROLE_ADMIN),
          new User(2L, "editor", "editor", Role.ROLE_EDITOR),
          new User(3L, "viewer", "viewer", Role.ROLE_VIEWER)
      )
      .collect(toMap(User::getId, identity()));

  public Optional<User> findById(Long id) {
    return Optional.ofNullable(USERS.get(id));
  }

  @Override
  public Optional<User> findByUserNameAndPassword(String username, String password) {
    return USERS.values()
        .stream()
        .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
        .findFirst();
  }
}
