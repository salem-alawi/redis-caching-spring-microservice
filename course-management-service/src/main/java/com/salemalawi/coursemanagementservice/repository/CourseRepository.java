package com.salemalawi.coursemanagementservice.repository;

import com.salemalawi.coursemanagementservice.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {



}
