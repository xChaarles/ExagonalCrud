package com.exaginalCrud.demo.domain.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Long id;
    private String name;
    private List<Student> studentList;

}
