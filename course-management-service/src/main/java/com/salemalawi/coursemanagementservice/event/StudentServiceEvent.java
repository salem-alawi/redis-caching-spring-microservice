package com.salemalawi.coursemanagementservice.event;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class StudentServiceEvent {


    @Bean
    public Consumer<ResourceChange> studentManagementServiceSink() {

        return resourceChange -> {
            System.out.println("student event happen");
        };

    }


}
