package com.sample.sboot.app.student;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentCSVServiceTest {

    @Mock
    private StudentCSVRepository studentCSVRepository;

    @InjectMocks
    private StudentCSVService studentCSVService;

    @Before
    public void setUp() throws Exception {
        String[] sss = {"1", "Test1", "Test2"};
        List<String[]> s = new ArrayList<>();
        s.add(sss);
        when(studentCSVRepository.readAll()).thenReturn(s);
    }

    @Test
    public void shouldGetAll() {
        List<Student> all = studentCSVService.findAll();
        assertThat(all).hasSize(1);
        assertThat(all.get(0).getId()).isEqualTo(1);
        assertThat(all.get(0).getName()).isEqualTo("Test1");
    }
}
