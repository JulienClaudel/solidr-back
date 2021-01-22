package com.solidrback.solidrback.service;

import com.solidrback.solidrback.model.entity.UserData;

import java.util.List;

public interface UserDataService {

    List<UserData> findAll();

    UserData save(UserData userData);
}
