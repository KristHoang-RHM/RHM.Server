package com.rhm.server.controllers;

import com.rhm.server.data.models.User;
import com.rhm.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
@CrossOrigin(originPatterns = "http://localhost:*")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  @Async
  public CompletableFuture<List<User>> findAll() {
    return userService.findAll();
  }
}
