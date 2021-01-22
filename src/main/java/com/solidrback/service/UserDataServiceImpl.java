package com.solidrback.service;

import com.solidrback.model.entity.UserData;
import com.solidrback.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public List<UserData> findAll() {
        return userDataRepository.findAll();
    }

    @Override
    public UserData save(UserData userData) {
        return userDataRepository.save(userData);
    }

}
