package com.salemalawi.coursemanagementservice.dto.courseStudent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salemalawi.coursemanagementservice.dto.course.CourseDto;
import com.salemalawi.coursemanagementservice.dto.student.StudentDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseStudentDto {

    private Long id;
    private CourseDto course;
    private StudentDto student;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

}
