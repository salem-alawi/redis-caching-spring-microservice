package com.salemalawi.studentmanagementservice.controller;


import com.salemalawi.studentmanagementservice.dto.student.StudentDto;
import com.salemalawi.studentmanagementservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("")
    public ResponseEntity findAllStudents(Pageable pageable){

        Page<StudentDto> studentDtoPage=this.studentService.findAllStudent(pageable)


    }

}
