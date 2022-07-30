package com.example.spring.mongodb.controller;

import com.example.spring.mongodb.model.Student;
import com.example.spring.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

   @GetMapping("/getAllStudent")
    public List<Student> studentList(){
       return studentService.getStudentList();
   }

}
