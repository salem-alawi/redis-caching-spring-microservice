package com.salemalawi.studentmanagementservice.event;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Service
public class CourseServiceEvent {


    @Bean
    public Consumer courseServiceSink() {
        return (d) -> {

        };
    }

}
