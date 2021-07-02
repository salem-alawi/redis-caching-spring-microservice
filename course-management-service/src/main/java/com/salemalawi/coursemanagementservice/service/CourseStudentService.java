package com.salemalawi.coursemanagementservice.service;


import com.salemalawi.coursemanagementservice.cache.StudentCachingService;
import com.salemalawi.coursemanagementservice.dto.courseStudent.CourseStudentDto;
import com.salemalawi.coursemanagementservice.exception.ExceptionMessage;
import com.salemalawi.coursemanagementservice.exception.ResourceNotFoundCustom;
import com.salemalawi.coursemanagementservice.model.CourseStudent;
import com.salemalawi.coursemanagementservice.repository.CourseStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class CourseStudentService {

    @Autowired
    private StudentCachingService studentCachingService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseStudentRepository courseStudentRepository;


    public Function<CourseStudent, CourseStudentDto> toDo() {

        return (courseStudent -> convertToDto(courseStudent));
    }

    private CourseStudentDto convertToDto(CourseStudent courseStudent) {
        CourseStudentDto courseStudentDto = this.modelMapper.map(courseStudent, CourseStudentDto.class);
        Optional.ofNullable(courseStudent.getStudentId()).ifPresent((studentId) -> {
            courseStudentDto.setStudent(this.studentCachingService.findOneById(courseStudent.getStudentId()));
        });
        return courseStudentDto;
    }

    public CourseStudentDto toDto(CourseStudent courseStudent) {
        return convertToDto(courseStudent);
    }

    public Page<CourseStudent> findAll(Pageable pageable) {

        return this.courseStudentRepository.findAll(pageable);
    }

    public CourseStudent findOneById(Long id) throws ResourceNotFoundCustom {
        return this.courseStudentRepository.findById(id).orElseThrow(ExceptionMessage.NOT_FOUND);
    }


}
