package com.sample.sboot.app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCSVService {

    @Autowired
    private StudentCSVRepository studentCSVRepository;

    public List<Student> findAll() {
        List<String[]> strings = studentCSVRepository.readAll();

        return strings.stream()
                .map(e -> new Student(Long.valueOf(e[0]), e[1], e[2]))
                .collect(Collectors.toList());
    }
}
