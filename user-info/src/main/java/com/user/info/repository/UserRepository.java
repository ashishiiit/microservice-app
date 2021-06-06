package com.user.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.info.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
