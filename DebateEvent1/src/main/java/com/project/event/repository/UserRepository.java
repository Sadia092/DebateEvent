package com.project.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.event.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
