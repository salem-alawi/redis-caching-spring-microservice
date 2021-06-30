package com.salemalawi.studentmanagementservice.exception;

import java.util.function.Supplier;

public class ExceptionMessage {

    public static final Supplier<ResourceNotFoundException> STUDENT_NOT_FOUND = () -> {
        return new ResourceNotFoundException("can't find student error-code");
    };


}
