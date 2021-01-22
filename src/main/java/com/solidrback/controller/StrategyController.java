package com.solidrback.controller;

import com.solidrback.exception.ResourceNotFoundException;
import com.solidrback.model.StrategyDTO;
import com.solidrback.model.entity.Profil;
import com.solidrback.model.entity.Strategy;
import com.solidrback.model.entity.UserProfil;
import com.solidrback.payload.response.MessageResponse;
import com.solidrback.repository.ProfilRepository;
import com.solidrback.repository.StrategyRepository;
import com.solidrback.repository.UserProfilRepository;
import com.solidrback.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/strategies")
public class StrategyController {
    @Autowired
    StrategyService strategyService;

    @Autowired
    StrategyRepository strategyRepository;

    @Autowired
    private ProfilRepository profilRepository;

    @Autowired
    private UserProfilRepository userProfilRepository;

    /// Get all strategies in database with the entity model
    @GetMapping("/")
    public List<Strategy> getAllStrategies() {
        return strategyService.findAll();
    }

    /// Get all strategies in database with DTO model
    @GetMapping("/all")
    public List<StrategyDTO> findAllStrat() {
        return strategyService.findAllStrat();
    }

    /// Find one strategy by id
    @GetMapping("/strategy/{id}")
    public ResponseEntity<StrategyDTO> findStratById(@PathVariable(value = "id") Integer strategyId) throws ResourceNotFoundException {
        StrategyDTO strategy = strategyRepository.findStratById(strategyId)
                .orElseThrow(() -> new ResourceNotFoundException("Strategy not found ::" + strategyId));
        return ResponseEntity.ok().body(strategy);
    }

    /// Find strategy by userEmail /// NEED TO BE CORRECTED ADD THE ID OF THE STRATEGY
    @GetMapping("/strat/{email}")
    public ResponseEntity<StrategyDTO> findByUserEmail(@PathVariable(value = "email") String userEmail) throws ResourceNotFoundException {
        StrategyDTO strategy = strategyRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Strategy not found ::" + userEmail));
        return ResponseEntity.ok().body(strategy);
    }

    /// Find all strategies by userEmail
    @GetMapping("/email/{email}")
    public List<StrategyDTO> findAllByUserEmail(@PathVariable(value = "email") String userEmail) {
        List<StrategyDTO> strategies = strategyService.findAllStratByUserEmail(userEmail);
        return strategies;
    }

    /// Find all strategies wich are not creates by the current user
    @GetMapping("/allstrategies/{email}")
    public List<StrategyDTO> findAllOtherStrategies(@PathVariable(value = "email") String userEmail) {
        List<StrategyDTO> strategies = strategyService.findAllOtherStrategies(userEmail);
        return strategies;
    }

    /// Create a new strategy
    @PreAuthorize("hasRole('Member')")
    @PostMapping("/")
    public ResponseEntity<?> createStrategy(@Valid @RequestBody Strategy strategy) {

        if (!strategyRepository.existsStrategyByStrategyLabel(strategy.getStrategyLabel())) {
            Profil profil = profilRepository.findByProfilLabel("Expert")
                    .orElseThrow(() -> new RuntimeException("Error: Profil is not found."));
            UserProfil userProfil = new UserProfil();
            userProfil.setUserEmail(strategy.getUserEmail());
            userProfil.setProfilId(profil.getProfilId());
            userProfilRepository.save(userProfil);

            return ResponseEntity.ok().body(strategyService.save(strategy));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Strategy already existing"));
    }

    /// Update one strategy by id
    @PreAuthorize("hasRole('Expert')")
    @PutMapping("/{id}")
    public ResponseEntity<Strategy> updateStrategy(@PathVariable(value = "id") Integer strategyId, @Valid @RequestBody Strategy strategy) {
        return ResponseEntity.ok().body(strategyService.save(strategy));
    }

    @PreAuthorize("hasRole('Expert')")
    @PutMapping("/delete/{id}")
    public ResponseEntity<Strategy> deleteStrategy(@PathVariable(value = "id") Integer strategyId) throws ResourceNotFoundException {
        Strategy strategy = strategyRepository.findByStrategyId(strategyId)
                .orElseThrow(() -> new ResourceNotFoundException("Strategy not found ::" + strategyId));
        return ResponseEntity.ok().body(strategyService.save(strategy));
    }

}
