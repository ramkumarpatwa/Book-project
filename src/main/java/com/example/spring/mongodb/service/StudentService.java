package com.example.spring.mongodb.service;

import com.example.spring.mongodb.model.Book;
import com.example.spring.mongodb.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getStudentList();

    Student addStudent(Student student);

    Optional<Student> getStudent(int id);
}
