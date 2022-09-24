package com.example.Samplespringboot.service;

import com.example.Samplespringboot.dto.UserSearchRequest;
import com.example.Samplespringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.Samplespringboot.entity.User;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public int getUserCount() {
        return userRepository.getUserCount();
    }

    @Override
    public List<User> userAll() {
        return userRepository.userAll();
    }

    @Override
    public User search(UserSearchRequest userId) {
        return userRepository.search(userId);
    }

    @Override
    public List<User> getUserList(HashMap<String, String> search) {
        int limit = Integer.valueOf(search.get("limit"));
        int page = Integer.valueOf(search.get("page")) - 1;
        int offset = limit * page;
        return userRepository.getUserList(limit, offset);
    }
}
