package com.salemalawi.studentmanagementservice.controller;


import com.salemalawi.studentmanagementservice.dto.student.StudentDto;
import com.salemalawi.studentmanagementservice.exception.ResourceNotFoundException;
import com.salemalawi.studentmanagementservice.model.Student;
import com.salemalawi.studentmanagementservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("")
    public ResponseEntity findAllStudents(Pageable pageable) {
        Page<StudentDto> studentDtoPage = this.studentService.findAllStudent(pageable).map(studentService.toDto());
        return new ResponseEntity(studentDtoPage, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findOneById(@PathVariable("id")Long id) throws ResourceNotFoundException {
        Student student= this.studentService.findById(id);
        StudentDto studentDto=this.studentService.toDto(student);
        return new ResponseEntity(studentDto,HttpStatus.OK);
    }

}
