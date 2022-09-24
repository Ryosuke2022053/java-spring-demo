package com.example.Samplespringboot.service;

import com.example.Samplespringboot.dto.UserSearchRequest;
import com.example.Samplespringboot.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {


    int getUserCount();

    List<User> userAll();

    User search(UserSearchRequest userId);

    List<User> getUserList(HashMap<String, String> search);
}
