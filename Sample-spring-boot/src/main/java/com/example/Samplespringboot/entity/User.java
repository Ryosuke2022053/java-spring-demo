package com.example.Samplespringboot.entity;

import java.util.Date;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
public class User {

    /**
     * ID
     */
    private Long id;

    /**
     * 名前
     */
    private String name;
}
