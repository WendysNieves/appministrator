package com.insoftar.controller;

import com.insoftar.domain.User;
import com.insoftar.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String createUserPage() {
        return "createUser";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

}