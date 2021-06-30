package com.salemalawi.studentmanagementservice.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salemalawi.studentmanagementservice.dto.ListItemResponse;
import com.salemalawi.studentmanagementservice.dto.course.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("$courseServiceUrl")
    String baseURL;

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
            try {
                hashOperations.put(COURSES, studentId, this.objectMapper.writeValueAsString(courses));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }




        return courses;


    }


}
