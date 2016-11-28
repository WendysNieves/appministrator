package com.insoftar.repository;

import com.insoftar.domain.User;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends DataTablesRepository<User, Long> {

}