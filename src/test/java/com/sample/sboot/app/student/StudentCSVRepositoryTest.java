package com.sample.sboot.app.student;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentCSVRepositoryTest {

    private StudentCSVRepository studentCSVRepository;

    @Before
    public void setUp() throws Exception {
        studentCSVRepository = new StudentCSVRepository();
    }

    @Test
    public void shouldReadAll() {
        List<String[]> strings = studentCSVRepository.readAll();
        strings
                .forEach(e -> System.out.println(e[0] + "," + e[1] + "," + e[2]));
    }

//    @Test
//    public void shouldWriteAll() {
//        studentCSVRepository.writeAll();
//    }
}
