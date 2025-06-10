package com.exaginalCrud.demo.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;

}
