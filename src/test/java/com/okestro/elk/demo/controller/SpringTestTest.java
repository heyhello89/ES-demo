package com.okestro.elk.demo.controller;

import com.okestro.elk.demo.dto.SpringTest;
import com.okestro.elk.demo.service.SpringTestService;
import org.elasticsearch.common.io.stream.Writeable;
import org.elasticsearch.search.DocValueFormat;
import org.hamcrest.core.IsNull;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTestTest {
    SpringTestService springTestService;

    @Before
    public void setup() {
        springTestService = new SpringTestService();
    }

    @Test
    public void whenValidParameter_thenSuccessFind() {
        List<SpringTest> list = springTestService.findAll();

        assertNotNull(list);
    }

    @Test
    public void whenValidParameter_thenSuccessSave() {
        Exception ex = null;

        try {
            springTestService.save(SpringTest.builder().message("안녕 이건 테스트야").name("오케스트로").build());
        } catch (Exception exception) {
            ex = exception;
        }

        assertNull(ex);
    }

    @Test
    public void whenValidParameter_thenSuccessFindByUser() {
        Exception ex = null;

        try {
            SpringTest play = springTestService.findByUsername("Braund, Mr. Owen Harris");

            assertThat(play, is(IsNull.notNullValue()));
        } catch (Exception exception) {
            ex = exception;
        }

        assertNull(ex);
    }
}
