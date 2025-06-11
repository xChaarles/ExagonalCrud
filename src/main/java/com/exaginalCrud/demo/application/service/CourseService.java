package com.exaginalCrud.demo.application.service;

import com.exaginalCrud.demo.application.ports.input.CourseServicePort;
import com.exaginalCrud.demo.application.ports.output.CoursePersistencePort;
import com.exaginalCrud.demo.domain.exception.CourseNotFoundException;
import com.exaginalCrud.demo.domain.model.Course;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseService implements CourseServicePort {

    private final CoursePersistencePort coursePersistencePort;

    @Override
    public Course findById(Long id) {
        return coursePersistencePort.findById(id)
                .orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public List<Course> findAll() {
        return coursePersistencePort.findAll();
    }

    @Override
    public Course save(Course course) {
        return coursePersistencePort.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        return coursePersistencePort.findById(id)
                .map(course1 -> {
                    course1.setName(course.getName());
                    return coursePersistencePort.save(course1);
                }).orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (coursePersistencePort.findById(id).isEmpty()){
            throw new CourseNotFoundException();
        }
        coursePersistencePort.deleteById(id);
    }
}
