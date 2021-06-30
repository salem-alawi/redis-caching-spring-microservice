package com.salemalawi.studentmanagementservice.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum  StudentGenderEnum {
    MALE_0,
    FEMALE_1;

    @JsonValue
    public Integer toValue(){
        return this.ordinal();
    }

}
