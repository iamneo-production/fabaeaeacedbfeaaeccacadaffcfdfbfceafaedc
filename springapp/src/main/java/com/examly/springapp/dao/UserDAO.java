package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
