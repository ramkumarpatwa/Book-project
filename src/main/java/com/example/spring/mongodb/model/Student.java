package com.example.spring.mongodb.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Document(collection = "Student")
public class Student {

    @Id
    int studentId;

    @Size(min=3, message = "studentName should be atleast of length 3")
    @Size(max=20, message = "studentName should be atmost of length 20")
    String studentName;

    @Length(min = 10, max = 10)
    long studentMobileNumber;

    @Size(min=3, message = "address should be atleast of length 3")
    @Size(max=100, message = "address should be atmost of length 100")
    String studentAddress;

    List<Book> bookList;
}
