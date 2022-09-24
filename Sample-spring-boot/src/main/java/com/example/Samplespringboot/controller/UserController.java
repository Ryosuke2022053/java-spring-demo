package com.example.Samplespringboot.controller;

import com.example.Samplespringboot.dto.UserSearchRequest;
import com.example.Samplespringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Samplespringboot.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * ユーザー情報 Controller
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final String limit = "3";
    private int showPageSize = 3;

    @GetMapping()
    public String userall(Model model) {
        List<User> userList = userService.userAll();
        model.addAttribute("userinfo", userList);
        return "index";
    }

    @GetMapping("list")
    public String userList(@RequestParam HashMap<String, String> params, Model model) {
        // 現在のページを設定し、現在のページを取得
        String currentPage = params.get("page");
        // 初期設定を1にする
        if (currentPage == null){
            currentPage = "1";
        }
        HashMap<String, String> search = new HashMap<String, String>();
        search.put("limit", limit);
        search.put("page", currentPage);

        int total = userService.getUserCount();
        List<User> list = userService.getUserList(search);

        int totalPage = (total + Integer.valueOf(limit) - 1) / Integer.valueOf(limit);
        int page = Integer.valueOf(currentPage);

        int startPage = page - (page-1)%showPageSize;
        int endPage = (startPage+showPageSize-1 > totalPage)? totalPage : startPage+showPageSize-1;

        model.addAttribute("list", list);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "pageList";
    }

    @GetMapping("/search")
    public String displaySearch(Model model) {
        User searchUser = new User();
        model.addAttribute("userSearchRequest", searchUser);
        return "search";
    }

    @PostMapping("/id_search")
    public String search(@ModelAttribute UserSearchRequest userId, Model model) {
        User user = userService.search(userId);
        model.addAttribute("userinfo", user);
        return "search";
    }
}