package com.salemalawi.coursemanagementservice.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course_students")
public class CourseStudent extends DateAudit{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
