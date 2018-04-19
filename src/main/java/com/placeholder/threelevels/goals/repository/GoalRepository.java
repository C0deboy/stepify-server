package com.placeholder.threelevels.goals.repository;

import com.placeholder.threelevels.goals.models.Goal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoalRepository extends MongoRepository<Goal, String> {
    List<Goal> findByOwner(ObjectId owner);
}
