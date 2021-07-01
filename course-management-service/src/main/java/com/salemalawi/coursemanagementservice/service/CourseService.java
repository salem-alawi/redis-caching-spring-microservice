package com.salemalawi.coursemanagementservice.service;


import com.salemalawi.coursemanagementservice.dto.CourseDto;
import com.salemalawi.coursemanagementservice.model.Course;
import com.salemalawi.coursemanagementservice.repository.CourseRepository;
import com.salemalawi.coursemanagementservice.repository.CourseStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.function.Function;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Function<Course, CourseDto> toDto() {

        return (course -> this.modelMapper.map(course, CourseDto.class));

    }

    public Page<Course> findAllCourse(Pageable pageable) {

        return this.courseRepository.findAll(pageable);


    }


}
