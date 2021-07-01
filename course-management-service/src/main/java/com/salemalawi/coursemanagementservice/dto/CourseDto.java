package com.salemalawi.coursemanagementservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDto {

    private Long id;
    private String name;
    private String category;

}
