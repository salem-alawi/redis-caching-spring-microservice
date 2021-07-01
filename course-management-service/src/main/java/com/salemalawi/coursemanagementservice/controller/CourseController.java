package com.salemalawi.coursemanagementservice.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {


    @GetMapping("")
    public ResponseEntity findAllCourse(Pageable pageable){




        return new ResponseEntity(HttpStatus.OK);
    }

}
