package com.example.demo.repository;

import com.example.demo.domain.User;
import java.util.Optional;

public interface UserRepository {
  Optional<User> findById(Long id);

  Optional<User> findByUserNameAndPassword(String username, String password);
}
