package com.salemalawi.coursemanagementservice.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course extends DateAudit {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;


}
