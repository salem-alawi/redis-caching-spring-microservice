package com.salemalawi.studentmanagementservice.dto.course;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDto {

    private Long id;
    private String name;
    private LocalDate enrollAt;

}
