package com.solidrback.solidrback.service;

import com.solidrback.solidrback.model.entity.UserData;
import com.solidrback.solidrback.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Implements UserDetailsService for authentication
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDataRepository userDataRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserData user = userDataRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

        return UserDetailsImpl.build(user);
    }
}
