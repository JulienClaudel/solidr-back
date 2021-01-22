package com.solidrback.controller;

import com.solidrback.exception.EmailNotFoundException;
import com.solidrback.model.entity.Profil;
import com.solidrback.model.entity.UserData;
import com.solidrback.model.entity.UserProfil;
import com.solidrback.payload.request.SignUpRequest;
import com.solidrback.payload.response.MessageResponse;
import com.solidrback.repository.ProfilRepository;
import com.solidrback.repository.UserDataRepository;
import com.solidrback.repository.UserProfilRepository;
import com.solidrback.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserProfilRepository userProfilRepository;

    @Autowired
    private ProfilRepository profilRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserDataRepository userDataRepository;

    // Check if the email address already exists in the BDD
    @GetMapping("/verify-email/{email}")
    public ResponseEntity<?> verifyEmail(@PathVariable(value = "email") String email) {

        if (email == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Your Email is null !"));
        } else if (userDataRepository.existsByUserEmail(email)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email is already taken !"));
        }
        return ResponseEntity.ok(new MessageResponse("Email is ok !"));
    }

    // Check if the username already exists in the BDD
    @GetMapping("/verify-username/{username}")
    public ResponseEntity<?> verifyUsername(@PathVariable(value = "username") String username) {

        if (username == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Your Username is null !"));
        } else if (userDataRepository.existsByUserUsername(username)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken !"));
        }
        return ResponseEntity.ok(new MessageResponse("Username is ok !"));
    }

    // Register of the user account
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        // Check if the username exists in the BDD
        if (userDataRepository.existsByUserUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Username is already taken !"));
        }

        // Check if the email exists in the BDD
        if (userDataRepository.existsByUserEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email is already taken !"));
        }

        // Add the current date and time for account creation
        Date userSignin = new Date();
        // Add the information to a new user received from the form register
        UserData user = new UserData(signUpRequest.getEmail(),
                1,
                signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                userSignin);

        // If he has activated double authentication then we add the secret and activate double authentication
        if (signUpRequest.isUsing2FA()) {
            user.setUserSecret(signUpRequest.getSecret());
            user.setUsing2FA(true);
        //Otherwise we don't activate it
        } else {
            user.setUsing2FA(false);
        }

        // Assign the role of simple user to the new user
        Set<Profil> profils = new HashSet<>();
        Profil userProfil = profilRepository.findByProfilLabel("User")
                .orElseThrow(() -> new RuntimeException("Error: Profil is not found."));
        profils.add(userProfil);

        user.setEnabled(false);
        user.setRoles(profils);
        // Generate a random token for confirm register by email
        user.setConfirmationToken(UUID.randomUUID().toString());
        userDataRepository.save(user);

        // Send an email with the token to confirm the email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUserEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("sldr.Solidr@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:4200/confirm-account?token=" + user.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    // If the user activates his account he becomes a member
    @PutMapping(value = "/confirm-account/")
    public ResponseEntity<?> confirmUserAccount(@Valid @RequestBody String confirmationToken) {
        UserData user = userDataRepository.findByConfirmationToken(confirmationToken);

        if (user != null) {
            user.setEnabled(true);
            userDataRepository.save(user);
            Profil profil = profilRepository.findByProfilLabel("Member")
                    .orElseThrow(() -> new RuntimeException("Error: Profil is not found."));
            UserProfil userProfil = new UserProfil();
            userProfil.setUserEmail(user.getUserEmail());
            userProfil.setProfilId(profil.getProfilId());
            userProfilRepository.save(userProfil);
            return ResponseEntity.ok(new MessageResponse("Your account is now fully activated!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("This link is invalid or broken !"));
        }
    }

    // If the user has not received or replied to the email at registration, he can request a new email
    @PreAuthorize("hasRole('User')")
    @GetMapping("/verify-account/{email}")
    public ResponseEntity<?> verifyAccount(@PathVariable(value = "email") String email) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        user.setConfirmationToken(UUID.randomUUID().toString());
        userDataRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUserEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("sldr.Solidr@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:4200/confirm-account?token=" + user.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);

        return ResponseEntity.ok(new MessageResponse("Email hase been sent again."));
    }
}
