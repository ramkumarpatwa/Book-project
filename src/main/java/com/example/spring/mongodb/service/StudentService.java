package com.example.spring.mongodb.service;

import com.example.spring.mongodb.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    Student addStudent(Student student);
}
