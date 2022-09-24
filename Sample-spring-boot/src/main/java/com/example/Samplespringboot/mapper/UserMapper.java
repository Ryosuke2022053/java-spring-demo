package com.example.Samplespringboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.Samplespringboot.dto.UserSearchRequest;
import com.example.Samplespringboot.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User search(UserSearchRequest userId);
    List<User> searchAll();

    int userCount();

    List<User> userList(int limit, int offset);
}