package com.mdc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mdc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    List<String> empty = new ArrayList<>();

//    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    @JsonView
    public String  indexPage() {
        return "try";
    }

    @RequestMapping("/addusers")
    public String addUsers() {

        return "ok";

    }
}