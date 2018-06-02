package com.placeholder.threelevels.goals.controller;

import com.placeholder.threelevels.goals.models.Goal;
import com.placeholder.threelevels.goals.repository.GoalRepository;
import com.placeholder.threelevels.users.CustomUser;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GoalController {
    private GoalRepository goalRepository;

    @Autowired
    public GoalController(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @GetMapping("/goals")
    public List<Goal> getAllGoals(Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return goalRepository.findByOwner(new ObjectId(customUser.getId()));
    }

    @PostMapping("/goals")
    public Goal addGoal(Authentication authentication, @Valid @RequestBody Goal goal) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        goal.setOwner(new ObjectId(customUser.getId()));

        return goalRepository.save(goal);
    }

    @PutMapping("/goals")
    public Goal updateGoal(@Valid @RequestBody Goal goal) {
        return goalRepository.save(goal);
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable String id) {
        return goalRepository.findById(id)
            .map(todo -> ResponseEntity.ok().body(todo))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/goals/{id}")
    public ResponseEntity<?> deleteGoal(@PathVariable String id) {
        return goalRepository.findById(id)
            .map(todo -> {
                goalRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

