package com.sample.sboot.app.student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldCreateStudent() {
        ResponseEntity<Student> responseEntity =
                restTemplate.postForEntity("/students", new Student(Long.valueOf(1), "Test1", "Test2"), Student.class);
        Student student = responseEntity.getBody();
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Test1", student.getName());
        assertEquals("Test2", student.getPassportNumber());
    }

}
