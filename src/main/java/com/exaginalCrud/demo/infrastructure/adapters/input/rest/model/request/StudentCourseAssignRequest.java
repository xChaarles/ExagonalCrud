package com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseAssignRequest {

    @NotNull(message = "Student ID cannot be null")
    private Long studentId;

    @NotNull(message = "Course ID cannot be null")
    private Long courseId;
}
