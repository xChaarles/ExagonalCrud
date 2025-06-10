package com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;
}
