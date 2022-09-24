package com.example.Samplespringboot.repository;

import com.example.Samplespringboot.dto.UserSearchRequest;
import com.example.Samplespringboot.entity.User;
import com.example.Samplespringboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public int getUserCount() {
        return userMapper.userCount();
    }

    @Override
    public List<User> userAll() {
        return userMapper.searchAll();
    }

    @Override
    public User search(UserSearchRequest userId) {
        return userMapper.search(userId);
    }

    @Override
    public List<User> getUserList(int limit, int offset) {
        return userMapper.userList(limit, offset);
    }
}
