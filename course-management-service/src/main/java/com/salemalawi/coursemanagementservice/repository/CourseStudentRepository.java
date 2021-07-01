package com.salemalawi.coursemanagementservice.repository;


import com.salemalawi.coursemanagementservice.model.CourseStudent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStudentRepository extends PagingAndSortingRepository<CourseStudent,Long> {



}
