package com.rhm.server.data.repositories;

import com.rhm.server.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//  List<User> findByUserName(String userName);
}