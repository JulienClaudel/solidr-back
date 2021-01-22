package com.solidrback.controller;

import com.solidrback.exception.EmailNotFoundException;
import com.solidrback.exception.ResourceNotFoundException;
import com.solidrback.model.entity.UserData;
import com.solidrback.repository.UserDataRepository;
import com.solidrback.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserDataService userService;

    // Get all users for the admin or staff
    @GetMapping("/all")
    public List<UserData> getAllUsers() {
        return userDataRepository.findAll();
    }

    // Get user by email
    @GetMapping("/user/{email}")
    public ResponseEntity<UserData> findUserByUserEmail(@PathVariable(value = "email") String email) throws ResourceNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with this email"));

        return ResponseEntity.ok().body(user);
    }

    // Update user information by Admin or Staff
    @PreAuthorize("hasRole('Staff')")
    @PutMapping("/update-user/{email}")
    public ResponseEntity<UserData> updateUsercloseAccount(@PathVariable(value = "email") String email, @Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        user.setUserUsername(userData.getUserUsername());
        user.setStatusId(userData.getStatusId());
        user.setUserFirstname(userData.getUserFirstname());
        user.setUserLastname(userData.getUserLastname());
        user.setUserBirthdate(userData.getUserBirthdate());
        user.setUserDescription(userData.getUserDescription());
        user.setUserLinkContact(userData.getUserLinkContact());
        user.setEnabled(userData.isEnabled());

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // add gas to the user
    @PreAuthorize("hasRole('Member')")
    @PutMapping("/update-gas/{email}")
    public ResponseEntity<UserData> updateGas(@PathVariable(value = "email") String email, @Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        user.setUserGaz(userData.getUserGaz());

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Admin can close the account of a user
    @PreAuthorize("hasRole('Staff')")
    @PutMapping("/close-account/{email}")
    public ResponseEntity<UserData> closeAccount(@PathVariable(value = "email") String email, @Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        user.setStatusId(11);
        user.setEnabled(false);
        user.setUserSecret(null);
        user.setUsing2FA(false);

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Admin can reactivate the account of a user
    @PreAuthorize("hasRole('Staff')")
    @PutMapping("/activate-account/{email}")
    public ResponseEntity<UserData> activateAccount(@PathVariable(value = "email") String email, @Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        user.setStatusId(1);
        user.setEnabled(true);

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
