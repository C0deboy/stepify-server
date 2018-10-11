package com.stepify.goals.repository;

import com.stepify.goals.models.Goal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoalRepository extends MongoRepository<Goal, String> {
    List<Goal> findByOwner(ObjectId owner);
}
