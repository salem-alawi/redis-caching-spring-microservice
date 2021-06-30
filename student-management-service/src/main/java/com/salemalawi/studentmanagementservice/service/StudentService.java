package com.salemalawi.studentmanagementservice.service;

import com.salemalawi.studentmanagementservice.dto.student.StudentDto;
import com.salemalawi.studentmanagementservice.exception.ExceptionMessage;
import com.salemalawi.studentmanagementservice.exception.ResourceNotFoundException;
import com.salemalawi.studentmanagementservice.model.Student;
import com.salemalawi.studentmanagementservice.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    Function<Student, StudentDto> toDto= (student -> {
        StudentDto studentDto= this.modelMapper.map(student,StudentDto.class);
        studentDto.setCourses();
    })


    public Page<Student> findAllStudent(Pageable pageable){
        return this.studentRepository.findAll(pageable);
    }
    public Student findById(Long id) throws ResourceNotFoundException {
        return this.studentRepository.findById(id).orElseThrow(ExceptionMessage.STUDENT_NOT_FOUND);
    }


}
