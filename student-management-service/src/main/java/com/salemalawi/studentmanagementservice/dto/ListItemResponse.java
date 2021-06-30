package com.salemalawi.studentmanagementservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListItemResponse<T> {
    private List<T> content;
}
