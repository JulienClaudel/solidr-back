package com.solidrback.solidrback.controller;

import com.solidrback.solidrback.model.UserSubscribeStratDTO;
import com.solidrback.solidrback.model.entity.UserSubscribeStrat;
import com.solidrback.solidrback.payload.response.MessageResponse;
import com.solidrback.solidrback.repository.UserSubscribeStratRepository;
import com.solidrback.solidrback.service.UserSubscribeStratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/subscribed")
public class UserSubscribeStratController {
    @Autowired
    UserSubscribeStratService userSubscribeStratService;

    @Autowired
    UserSubscribeStratRepository userSubscribeStratRepository;

    /// Find all strategies followed by one user
    @GetMapping("/email/{email}")
    public List<UserSubscribeStratDTO> findAllByUserEmail(@PathVariable(value = "email") String userEmail) {
        return userSubscribeStratService.findAllByUserEmail(userEmail);
    }

    /// Find all followers of a strategy
    @GetMapping("/id/{id}")
    public List<UserSubscribeStratDTO> findAllByStrategyId(@PathVariable(value = "id") int strategyId) {
        return userSubscribeStratService.findAllByStrategyId(strategyId);
    }

    // Find all FOLLOWERS where EXPERT is
    @GetMapping("/followers/{email}")
    List<UserSubscribeStratDTO> findAllFollowersByExpert(@PathVariable(value = "email") String userEmail) {
        return userSubscribeStratService.findAllFollowersByExpert(userEmail);
    }

    // Find all FOLLOWERS by EXPERT'S ANGEL where EXPERT is
    @GetMapping("/followersangel/{id}/{email}")
    List<UserSubscribeStratDTO> findAllFollowersByAngelAndExpert(@PathVariable(value = "id") int strategyId, @PathVariable(value = "email") String userEmail) {
        return userSubscribeStratService.findAllFollowersByAngelAndExpert(strategyId, userEmail);
    }

    // Find all ANGELS FOLLOWED by one MEMBER
    @GetMapping("/angels/{email}")
    List<UserSubscribeStratDTO> findAllAngelsFollowedByUser(@PathVariable(value = "email") String userEmail) {
        return userSubscribeStratService.findAllAngelsFollowedByUser(userEmail);
    }

    @PostMapping("/")
    public ResponseEntity<?> createSubscription(@Valid @RequestBody UserSubscribeStrat userSubscribeStrat) {
        if (!userSubscribeStratRepository.existsUserSubscribeStratByStrategyIdAndUserEmail(userSubscribeStrat.getStrategyId(), userSubscribeStrat.getUserEmail())) {
            return ResponseEntity.ok().body(userSubscribeStratService.save(userSubscribeStrat));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("You are already following this angel"));
    }

}
