package com.salemalawi.studentmanagementservice.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salemalawi.studentmanagementservice.dto.ListItemResponse;
import com.salemalawi.studentmanagementservice.dto.course.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CourseCachingService {

    private static final String COURSES = "COURSES_KEY_FOR_STUDENT_SERVICE";


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    RestTemplate restTemplate = new RestTemplate();
    String baseURL = "http://localhost:8081";

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    public List<CourseDto> findAllCourseByStudentId(Long studentId) {

        List<CourseDto> courses = null;

        try {
            courses = this.objectMapper.readValue((String) hashOperations.get(COURSES, studentId), List.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (courses != null)
            return courses;

        ResponseEntity<ListItemResponse> responseResponseEntity = restTemplate.getForEntity(baseURL + "/students/" + studentId + "/courses", ListItemResponse.class);
        if (responseResponseEntity.getStatusCode().is2xxSuccessful()) {
            courses = (List<CourseDto>) responseResponseEntity.getBody().getContent();
            return courses;
        }


    }


}
