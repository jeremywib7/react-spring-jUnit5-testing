package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepoTest;

    @AfterEach
    void tearDown() {
        studentRepoTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // give
        String email = "jamila@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                Gender.FEMALE
        );
        studentRepoTest.save(student);

        // when
        boolean expected = studentRepoTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        // give
        String email = "jamila@gmail.com";

        // when
        boolean expected = studentRepoTest.selectExistsEmail(email);

        //then
        assertThat(expected).isFalse();
    }

}