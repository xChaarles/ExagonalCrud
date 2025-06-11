package com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCourseAssignRequest {

    @NotNull(message = "Student ID cannot be null")
    @JsonProperty("studentId")
    private Long studentId;

    @NotNull(message = "Course ID cannot be null")
    @JsonProperty("courseId")
    private Long courseId;

}
