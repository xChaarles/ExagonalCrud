package com.exaginalCrud.demo.application.ports.output;

import com.exaginalCrud.demo.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface CoursePersistencePort {

    Optional<Course> findById(Long id);
    List<Course> findAll();
    Course save(Course course);

    void deleteById (Long id);
}
