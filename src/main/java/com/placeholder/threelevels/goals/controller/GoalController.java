package com.placeholder.threelevels.goals.controller;

import com.placeholder.threelevels.goals.models.Goal;
import com.placeholder.threelevels.goals.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class GoalController {
  private GoalRepository goalRepository;

  @Autowired
  public GoalController(GoalRepository goalRepository) {
    this.goalRepository = goalRepository;
  }

  @GetMapping("/goals")
  public List<Goal> getAllGoals(Principal principal) {
    return goalRepository.findByOwner(principal.getName());
  }

  @PostMapping("/goals")
  public Goal addGoal(@RequestBody Goal goal) {
    return goalRepository.save(goal);
  }

  @PutMapping("/goals")
  public Goal updateGoal(@RequestBody Goal goal) {
    return goalRepository.save(goal);
  }

  @GetMapping("/goals/{id}")
  public ResponseEntity<Goal> getTodoById(@PathVariable String id) {
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

