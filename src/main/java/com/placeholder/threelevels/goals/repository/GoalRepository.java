package com.placeholder.threelevels.goals.repository;

import com.placeholder.threelevels.goals.models.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface GoalRepository extends MongoRepository<Goal, String> {
  List<Goal> findByOwner(String owner);
}
