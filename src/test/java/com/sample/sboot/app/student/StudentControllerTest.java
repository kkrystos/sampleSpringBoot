package com.sample.sboot.app.student;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    StudentController studentController;

    @Before
    public void setUp() throws Exception {
        given(studentRepository.findAll()).willReturn(Arrays.asList(new Student(Long.MIN_VALUE, "Test", "Test")));
    }

    @Test
    public void name() {
        List<Student> actual = studentController.getAllStudents();
        assertEquals(actual.get(0).getName(), "Test");

    }

    @Test
    public void testHello() {
        System.out.println("hello");
        StudentController instance = new StudentController();
        String expResult = "Hello from App :)";
        String result = instance.hello();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getAllStudents method, of class StudentController.
//     */
//    @Test
//    public void testGetAllStudents() {
//        System.out.println("getAllStudents");
//        StudentController instance = new StudentController();
//        List<Student> expResult = null;
//        List<Student> result = instance.getAllStudents();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createStudent method, of class StudentController.
//     */
//    @Test
//    public void testCreateStudent() {
//        System.out.println("createStudent");
//        Student student = null;
//        StudentController instance = new StudentController();
//        String expResult = "";
//        String result = instance.createStudent(student);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
