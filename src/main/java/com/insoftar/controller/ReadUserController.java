package com.insoftar.controller;

import com.insoftar.domain.User;
import com.insoftar.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReadUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String usersListPage() {
        return "usersList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesOutput<User> userList(DataTablesInput input) {
        return userService.findAll(input);
    }

}