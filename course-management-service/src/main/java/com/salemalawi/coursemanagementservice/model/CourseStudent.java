package com.salemalawi.coursemanagementservice.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course_students")
public class CourseStudent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

}
