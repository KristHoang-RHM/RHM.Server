package com.rhm.server.data.services;

import com.rhm.server.data.models.User;
import com.rhm.server.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Async
  public CompletableFuture<List<User>> findAll() {
    return CompletableFuture.completedFuture(userRepository.findAll());
  }

  @Async
  public CompletableFuture<User> createUser() {
    return CompletableFuture.completedFuture(new User());
  }
}
