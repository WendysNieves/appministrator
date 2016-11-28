package com.insoftar.controller;

import com.insoftar.domain.User;
import com.insoftar.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String updateUserPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updateUser";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateUser(User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

}