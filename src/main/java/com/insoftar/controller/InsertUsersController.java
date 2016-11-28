package com.insoftar.controller;

import com.insoftar.domain.User;
import com.insoftar.service.IUserService;
import com.insoftar.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsertUsersController {

    private static final int CELLPHONE_LENGTH = 10;
    private static final int BEGIN_EMAIL_LENGTH = 31;
    private static final String END_EMAIL_STRING = "@appministrator.com";
    private static final int IDENTIFICATION_LENGTH = 20;
    private static final int NAME_OR_LASTNAME_LENGTH = 50;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users/generate", method = RequestMethod.POST)
    public ResponseEntity<String> generateUsers(@RequestParam(value = "length",
    defaultValue = "100") int length) {

        for (int i = 0; i < length; i++) {
            User user = new User();
            user.setCellphone(Util.generateRandomNumericString(CELLPHONE_LENGTH));
            user.setEmail(Util.generateRandomAlphanumericString(BEGIN_EMAIL_LENGTH)
                            + END_EMAIL_STRING);
            user.setIdentification(Util.generateRandomNumericString(IDENTIFICATION_LENGTH));
            user.setLastName(Util.generateRandomAlphabeticString(NAME_OR_LASTNAME_LENGTH));
            user.setName(Util.generateRandomAlphabeticString(NAME_OR_LASTNAME_LENGTH));

            userService.save(user);
        }

        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}