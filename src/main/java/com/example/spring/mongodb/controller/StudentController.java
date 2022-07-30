package com.example.spring.mongodb.controller;

import com.example.spring.mongodb.model.Book;
import com.example.spring.mongodb.model.Student;
import com.example.spring.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

   @GetMapping("getStudent/{id}")
    public Optional<Student> student(@PathVariable int id){
        return studentService.getStudent(id);
   }

}
