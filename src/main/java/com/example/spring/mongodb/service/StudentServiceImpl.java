package com.example.spring.mongodb.service;

import com.example.spring.mongodb.model.Book;
import com.example.spring.mongodb.model.Student;
import com.example.spring.mongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookService bookService;

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Book> getBookListByStudentId(int student_id) {
        Optional<Student> optionalStudent = studentRepository.findById(student_id);
        List<Book> bookList = optionalStudent.get().getBookList();
        return  bookList;
    }

    @Override
    public Student addExistingBookToStudent(int student_id, int book_id) {
        Optional<Student> student = getStudent(student_id);
        List<Book> bookList = student.get().getBookList();
        Optional<Book> bookById = bookService.getBookById(book_id);
        bookList.add(bookById.get());
        return studentRepository.save(student.get());
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
