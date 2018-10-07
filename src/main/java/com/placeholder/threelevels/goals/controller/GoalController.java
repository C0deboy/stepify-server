package com.placeholder.threelevels.goals.controller;

import com.placeholder.threelevels.goals.models.Goal;
import com.placeholder.threelevels.goals.repository.GoalRepository;
import com.placeholder.threelevels.users.CustomUser;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Comparator;
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
        ObjectId userId = new ObjectId(customUser.getId());
//        Sort sortByOrder = new Sort(Sort.DEFAULT_DIRECTION, "order");

        List<Goal> goals = goalRepository.findByOwner(userId);
        goals.sort(Comparator.comparing(Goal::getOrder));
        return goals;
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

