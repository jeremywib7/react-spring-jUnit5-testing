package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AllArgsConstructor
class StudentRepositoryTest {

    private final StudentRepository studentRepoTest;

    @Test
    void itShouldCheckIfStudentExistsEmail() {
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

}