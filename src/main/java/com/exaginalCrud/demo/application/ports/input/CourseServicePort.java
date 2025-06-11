package com.exaginalCrud.demo.application.ports.input;

import com.exaginalCrud.demo.domain.model.Course;

import java.util.List;

public interface CourseServicePort {

    Course findById(Long id);
    List<Course> findAll();
    Course save(Course course);
    Course update(Long id, Course course);

    void deleteById(Long id);

}
