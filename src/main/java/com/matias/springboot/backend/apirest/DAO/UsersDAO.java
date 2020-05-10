package com.matias.springboot.backend.apirest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matias.springboot.backend.apirest.entity.User;

public interface UsersDAO extends JpaRepository<User, Integer> {

}
