package com.insoftar.service;

import com.insoftar.domain.User;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface IUserService {

    User save(User user);

    User findById(Long id);

    void delete(Long id);

    DataTablesOutput<User> findAll(DataTablesInput input);
}