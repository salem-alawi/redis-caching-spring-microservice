package com.salemalawi.studentmanagementservice.repository;

import com.salemalawi.studentmanagementservice.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {



}
