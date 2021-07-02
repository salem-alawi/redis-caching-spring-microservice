package com.salemalawi.coursemanagementservice.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salemalawi.coursemanagementservice.dto.student.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class StudentCachingService {

    private static final String STUDENT = "STUDENT_KEY_FOR_COURSE_SERVICE";


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    RestTemplate restTemplate = new RestTemplate();

    @Value("$url.studentService")
    String baseURL;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    public StudentDto findOneById(Long studentId) {

        StudentDto student = null;

        try {
            student = this.objectMapper.readValue((String) hashOperations.get(STUDENT, studentId), StudentDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (student != null)
            return student;

        ResponseEntity<StudentDto> responseResponseEntity = restTemplate.getForEntity(baseURL + "/students/" + studentId , StudentDto.class);
        if (responseResponseEntity.getStatusCode().is2xxSuccessful()) {
            student = responseResponseEntity.getBody();
            try {
                hashOperations.put(STUDENT, studentId, this.objectMapper.writeValueAsString(student));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
