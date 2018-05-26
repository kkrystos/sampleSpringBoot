package com.sample.sboot.app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class StudentCSVController {

    @Autowired
    StudentCSVService studentCSVService;

    @Autowired
    StudentCSVRepository studentCSVRepository;

    @GetMapping("/csv/students")
    public List<Student> getAllStudents() {
        List<Student> findAll = studentCSVService.findAll();
        return findAll;
    }

    @GetMapping(value = "/csv/students/write", produces = "text/csv")
    public void writeStudents(HttpServletResponse response) throws IOException {
        studentCSVRepository.writeAll(response.getWriter());

    }
}
