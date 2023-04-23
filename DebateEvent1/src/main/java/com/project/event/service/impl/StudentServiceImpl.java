package com.project.event.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.project.event.entity.Student;
import com.project.event.repository.*;
import com.project.event.service.*;

public class StudentServiceImpl implements StudentService {

	
	@Autowired
    private StudentRepository studentRepository;
   
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }


    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
