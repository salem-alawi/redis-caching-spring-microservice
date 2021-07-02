package com.salemalawi.coursemanagementservice.dto.student;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer gender;
    private LocalDate registerAt;
}
