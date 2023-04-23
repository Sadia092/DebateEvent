package com.project.event.controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.event.entity.Student;
import com.project.event.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {
	


    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
   
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }  
    
    @GetMapping("/students/new")
   public String createStudentForm(Model model) {
       
       Student student = new Student();
       model.addAttribute("student", student);
       return "create_student";
   }


   @PostMapping("/students")
   public String saveStudent(
           @ModelAttribute("student") Student student) {
       studentService.saveStudent(student);
       return "redirect:/students";
   }  
   
   @GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
   
   @PostMapping("/students/{id}")
	public String updateStudent(
			@PathVariable Long id, 
			@ModelAttribute("student") Student student, 
			Model model) {

		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setCountry(student.getCountry());

	
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}	

   
   @GetMapping("/students/{id}")
   public String deleteStudent(@PathVariable Long id) {
       studentService.deleteStudentById(id);
       return "redirect:/students";
   }

   


}
