package com.solidrback.service;

import com.solidrback.model.entity.UserData;

import java.util.List;

public interface UserDataService {

    List<UserData> findAll();

    UserData save(UserData userData);
}
