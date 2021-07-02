package com.salemalawi.coursemanagementservice.controller;

import com.salemalawi.coursemanagementservice.dto.courseStudent.CourseStudentDto;
import com.salemalawi.coursemanagementservice.exception.ResourceNotFoundCustom;
import com.salemalawi.coursemanagementservice.model.CourseStudent;
import com.salemalawi.coursemanagementservice.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseStudentController {

    @Autowired
    private CourseStudentService courseStudentService;


    @GetMapping("/course-students")
    public ResponseEntity findAllCourseStudent(Pageable pageable) {

        Page<CourseStudentDto> courseStudentDtoPage = this.courseStudentService.findAll(pageable).map(this.courseStudentService.toDo());
        return new ResponseEntity(courseStudentDtoPage, HttpStatus.OK);
    }

    @GetMapping("/curse-students/{id}")
    public ResponseEntity findOneByIdCourseStudent(@PathVariable("id")Long id) throws ResourceNotFoundCustom {

        CourseStudent courseStudent= this.courseStudentService.findOneById(id);
        CourseStudentDto courseStudentDto=this.courseStudentService.toDto(courseStudent);
        return new ResponseEntity(courseStudentDto,HttpStatus.OK);

    }

}
