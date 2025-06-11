package com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest {

    @NotBlank(message = "Field name cannot be empty or null")
    private String name;

}
