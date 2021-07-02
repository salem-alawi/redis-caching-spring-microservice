package com.salemalawi.coursemanagementservice.controller;

import com.salemalawi.coursemanagementservice.dto.CourseDto;
import com.salemalawi.coursemanagementservice.exception.ResourceNotFoundCustom;
import com.salemalawi.coursemanagementservice.model.Course;
import com.salemalawi.coursemanagementservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {


    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity findAllCourse(Pageable pageable) {

        Page<CourseDto> courseDtos = this.courseService.findAllCourse(pageable).map(this.courseService.toDto());
        return new ResponseEntity(courseDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findOneById(@PathVariable("id")Long id) throws ResourceNotFoundCustom {

        Course course= this.courseService.findOneById(id);
        CourseDto courseDto=this.courseService.toDto(course);

        return new ResponseEntity(courseDto,HttpStatus.OK);
    }

}
