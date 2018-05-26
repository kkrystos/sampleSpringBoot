package com.sample.sboot.app.student;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String createStudent(@RequestBody Student student) {
        studentRepository.save(student);

        return "oki!";
    }
}
