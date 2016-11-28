package com.insoftar.controller;

import com.insoftar.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}