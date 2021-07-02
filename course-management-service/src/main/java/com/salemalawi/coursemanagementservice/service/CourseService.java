package com.salemalawi.coursemanagementservice.service;


import com.salemalawi.coursemanagementservice.dto.course.CourseDto;
import com.salemalawi.coursemanagementservice.exception.ExceptionMessage;
import com.salemalawi.coursemanagementservice.exception.ResourceNotFoundCustom;
import com.salemalawi.coursemanagementservice.model.Course;
import com.salemalawi.coursemanagementservice.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public CourseDto toDto(Course course) {
        return this.modelMapper.map(course,CourseDto.class);
    }

    public Page<Course> findAllCourse(Pageable pageable) {
        return this.courseRepository.findAll(pageable);
    }

    public Course findOneById(Long id) throws ResourceNotFoundCustom {
        return this.courseRepository.findById(id).orElseThrow(ExceptionMessage.NOT_FOUND);
    }


}
