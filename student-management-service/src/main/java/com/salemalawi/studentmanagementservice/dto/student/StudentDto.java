package com.salemalawi.studentmanagementservice.dto.student;

import com.salemalawi.studentmanagementservice.dto.course.CourseDto;
import com.salemalawi.studentmanagementservice.model.enums.StudentGenderEnum;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private StudentGenderEnum gender;
    private LocalDate registerAt;
    private List<CourseDto> courses;

}
