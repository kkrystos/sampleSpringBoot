package com.sample.sboot.app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello from App using git:)";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> findAll = studentRepository.findAll();
        return findAll;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }
}
