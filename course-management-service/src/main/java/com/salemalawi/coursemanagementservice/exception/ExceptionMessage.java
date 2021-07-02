package com.salemalawi.coursemanagementservice.exception;

import java.util.function.Supplier;

public class ExceptionMessage {

    public static final Supplier<ResourceNotFoundCustom> NOT_FOUND=()-> new ResourceNotFoundCustom("can't find Resource");

}
