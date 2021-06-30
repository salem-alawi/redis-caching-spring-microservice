package com.salemalawi.studentmanagementservice.model;

import com.salemalawi.studentmanagementservice.model.enums.StudentGenderEnum;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private Integer age;
    @Enumerated(EnumType.ORDINAL)
    private StudentGenderEnum gender;
    private LocalDate registerAt;
}
