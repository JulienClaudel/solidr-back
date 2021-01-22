package com.solidrback.solidrback.controller;

import com.solidrback.solidrback.exception.EmailNotFoundException;
import com.solidrback.solidrback.model.entity.UserData;
import com.solidrback.solidrback.payload.request.LoginRequest;
import com.solidrback.solidrback.payload.response.JwtResponse;
import com.solidrback.solidrback.payload.response.MessageResponse;
import com.solidrback.solidrback.repository.UserDataRepository;
import com.solidrback.solidrback.security.JwtUtils;
import com.solidrback.solidrback.service.EmailSenderService;
import com.solidrback.solidrback.service.UserDetailsImpl;
import org.jboss.aerogear.security.otp.Totp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/login")
public class LogInController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    // Method for authenticate the user with no authenticator
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws EmailNotFoundException {

        // Check if the email and password match
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Generates a token from the authentication
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        // Get the list of roles linked to the user's token
        List<String> profils = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        // Get the user by the email address
        UserData currentUser = userDataRepository.findByUserEmail(userDetails.getEmail())
                .orElseThrow(() -> new EmailNotFoundException("User not found with this email ::" + userDetails.getEmail()));

        // Send the user information corresponding to the login
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getEmail(),
                currentUser.getStatusId(),
                userDetails.getUsername(),
                currentUser.getUserFirstname(),
                currentUser.getUserLastname(),
                currentUser.getUserBirthdate(),
                currentUser.getUserDescription(),
                currentUser.getUserLinkContact(),
                currentUser.getUserGaz(),
                currentUser.isEnabled(),
                currentUser.isUsing2FA(),
                currentUser.getUserSecret(),
                profils));
    }

    // Method for authenticate the user with no authenticator
    @PostMapping("/verify-totp/{code}")
    public ResponseEntity<?> totp(@PathVariable(value = "code") String code, @Valid @RequestBody LoginRequest loginRequest) throws EmailNotFoundException {
        // Get the user by the email
        UserData user = userDataRepository.findByUserEmail(loginRequest.getEmail())
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + loginRequest.getEmail()));

        // Retrieves the secret linked to the user
        String secret = user.getUserSecret();
        // Check if the secret and the generate code are not null
        if (secret != null && code != null) {
            // Check if the generate code is associated with the secret
            Totp totp = new Totp(secret);
            if (totp.verify(code)) {
                // Generates a token from the authentication
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // Generates a token from the authentication
                String jwt = jwtUtils.generateJwtToken(authentication);
                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                // Get the list of roles linked to the user's token
                List<String> profils = userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList());
                // Get the user by the email
                UserData currentUser = userDataRepository.findByUserEmail(userDetails.getEmail())
                        .orElseThrow(() -> new EmailNotFoundException("User not found with this email ::" + userDetails.getEmail()));

                // Send the user information corresponding to the login
                return ResponseEntity.ok(new JwtResponse(jwt,
                        userDetails.getEmail(),
                        currentUser.getStatusId(),
                        userDetails.getUsername(),
                        currentUser.getUserFirstname(),
                        currentUser.getUserLastname(),
                        currentUser.getUserBirthdate(),
                        currentUser.getUserDescription(),
                        currentUser.getUserLinkContact(),
                        currentUser.getUserGaz(),
                        currentUser.isEnabled(),
                        currentUser.isUsing2FA(),
                        currentUser.getUserSecret(),
                        profils));
            }
            // Return a negative response because the generate code is invalid
            return ResponseEntity.badRequest().body(new MessageResponse("The QR Code is invalid !"));
        }
        // Return a negative response because the secret or the generate code are null
        return ResponseEntity.badRequest().body(new MessageResponse(("The secret or the code is null")));

    }

    // Mthod that sends an email to the user to confirm the password reset request
    @GetMapping(value = "/forgot-password/{email}")
    public ResponseEntity<?> forgotPassword(@PathVariable(value = "email") String email) throws EmailNotFoundException {

        // Get the user by the email
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        // Check if the user email exist and send a mail
        if (user != null) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email);
            mailMessage.setSubject("Complete Password Reset!");
            mailMessage.setFrom("sldr.solidr@gmail.com");
            mailMessage.setText("To complete the password reset process, please click here: "
                    + "http://localhost:4200/reset-password?token=" + user.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            return ResponseEntity.ok(new MessageResponse("Request to reset password received. Check your inbox for the reset link."));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("This email don't exist !"));
        }
    }

    // Request Mapping to receive the confirmation of the token and send the link to reset the password
    @PutMapping(value = "/reset-password/{token}")
    public ResponseEntity<?> validateResetToken(@PathVariable(value = "token") String token,
                                                @Valid @RequestBody String password) {

        UserData userData = userDataRepository.findByConfirmationToken(token);
        if (userData != null) {

            userData.setUserPassword(encoder.encode(password));

            userDataRepository.save(userData);
            return ResponseEntity.ok(new MessageResponse("Your password is now reset"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Your token is invalid"));
        }
    }
}
