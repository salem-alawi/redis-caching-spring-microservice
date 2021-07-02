package com.salemalawi.coursemanagementservice.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseStudentController {




    @GetMapping("/course-students")
    public ResponseEntity findAllCourseStudent(Pageable pageable){





    }

}
