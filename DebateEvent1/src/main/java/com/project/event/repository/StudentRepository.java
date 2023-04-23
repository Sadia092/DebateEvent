package com.project.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.event.entity.*;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
