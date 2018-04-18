package com.placeholder.threelevels.users;

import com.placeholder.threelevels.goals.models.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface UserRepository extends MongoRepository<User, String> {
  User findByUsername(String username);
}
