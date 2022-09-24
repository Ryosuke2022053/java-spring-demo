package com.example.Samplespringboot.repository;

import com.example.Samplespringboot.dto.UserSearchRequest;
import com.example.Samplespringboot.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserRepository {
    int getUserCount();

    List<User> userAll();
    User search(UserSearchRequest userId);

    List<User> getUserList(int limit, int offset);
}
