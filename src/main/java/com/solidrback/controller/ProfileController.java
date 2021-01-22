package com.solidrback.controller;

import com.solidrback.exception.EmailNotFoundException;
import com.solidrback.model.entity.UserData;
import com.solidrback.payload.response.MessageResponse;
import com.solidrback.repository.UserDataRepository;
import com.solidrback.service.EmailSenderService;
import com.solidrback.service.UserDataService;
import org.jboss.aerogear.security.otp.Totp;
import org.jboss.aerogear.security.otp.api.Base32;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserDataService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    // Generates a random code to send to the front and linked to User
    @GetMapping("/secret")
    public String getSecret() {
        String secret = Base32.random();
        return secret;
    }

    // Check if the username already exists in the BDD
    @GetMapping("/user-token/{token}")
    public ResponseEntity<UserData> verifyUsername(@PathVariable(value = "token") String token) {
        UserData userData = userDataRepository.findByConfirmationToken(token);
        System.out.println(userData);
        return ResponseEntity.ok().body(userData);
    }


    // Email sent to confirm that it belongs to the user to reactivate their account with his token
    @GetMapping("/confirm-reactivate/{email}")
    public ResponseEntity<?> confirmReactivateAccount(@PathVariable(value = "email") String email) throws EmailNotFoundException {

        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Reactivate your account!");
        mailMessage.setFrom("sldr.solidr@gmail.com");
        mailMessage.setText("If you want to reactivate your account, please click here: "
                + "http://localhost:4200/verify-email?token=" + user.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);

        return ResponseEntity.ok(new MessageResponse("This account is close ! An email has been sent if you want to reactivate this account."));
    }

    // If the token corresponds to the user, his account is reactivated
    @PutMapping("/reactivate-account/")
    public ResponseEntity<?> reactivateAccount(@Valid @RequestBody UserData userData) {
        UserData user = userDataRepository.findByConfirmationToken(userData.getConfirmationToken());

        if (user != null) {
            user.setStatusId(1);
            user.setEnabled(true);
            userDataRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("Your account is now reactivated !"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Your link is broken !"));
        }
    }

    // Check if the generate code is associated with the secret
    @GetMapping("/confirm-secret/{code}&{secret}")
    public ResponseEntity<?> confirmSecret(@PathVariable(value = "code") String code,
                                           @PathVariable(value = "secret") String secret) {

        Totp totp = new Totp(secret);
        if (totp.verify(code)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("The Qr Code is invalid !"));
        }
    }

    // Activate two-factor authentication directly from the profile
    @PreAuthorize("hasRole('User')")
    @PutMapping("/activate-2fa")
    public ResponseEntity<UserData> activate2FA(@Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(userData.getUserEmail())
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + userData.getUserEmail()));

        // Set two-factor authentication to false and add the new user secret
        user.setUserSecret(userData.getUserSecret());
        user.setUsing2FA(true);

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Disable two-factor authentication directly from the profile
    @PreAuthorize("hasRole('User')")
    @PutMapping("/deactivate-2fa")
    public ResponseEntity<UserData> deactivate2FA(@Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(userData.getUserEmail())
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + userData.getUserEmail()));

        // Set two-factor authentication to false and remove the secret key
        user.setUsing2FA(false);
        user.setUserSecret(null);

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // The user can deactivate his account from his profile
    @PreAuthorize("hasRole('User')")
    @PutMapping("/close-account")
    public ResponseEntity<UserData> closeAccount(@Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(userData.getUserEmail())
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + userData.getUserEmail()));

        user.setStatusId(11);
        user.setEnabled(false);
        user.setUserSecret(null);
        user.setUsing2FA(false);

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Add additional information to the user profile
    @PreAuthorize("hasRole('Member')")
    @PutMapping("/add-informations/{email}")
    public ResponseEntity<UserData> addInformation(@PathVariable(value = "email") String email, @Valid @RequestBody UserData userData) throws EmailNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        // Activate the user when he adds the information to his account
        user.setStatusId(10);
        user.setUserFirstname(userData.getUserFirstname());
        user.setUserLastname(userData.getUserLastname());
        user.setUserBirthdate(userData.getUserBirthdate());
        user.setUserDescription(userData.getUserDescription());
        user.setUserLinkContact(userData.getUserLinkContact());

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Modify user profile information
    @PreAuthorize("hasRole('Member')")
    @PutMapping("/update-profile/{email}")
    public ResponseEntity<UserData> updateProfile(@PathVariable(value = "email") String email, @Valid @RequestBody UserData userData) throws EmailNotFoundException {

        // Get the user by the email
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found ::" + email));

        user.setUserFirstname(userData.getUserFirstname());
        user.setUserLastname(userData.getUserLastname());
        user.setUserBirthdate(userData.getUserBirthdate());
        user.setUserDescription(userData.getUserDescription());
        user.setUserLinkContact(userData.getUserLinkContact());

        final UserData updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
