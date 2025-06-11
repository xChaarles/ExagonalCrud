package com.exaginalCrud.demo.infrastructure.adapters.output.persistence;

import com.exaginalCrud.demo.application.ports.output.CoursePersistencePort;
import com.exaginalCrud.demo.domain.model.Course;
import com.exaginalCrud.demo.infrastructure.adapters.output.persistence.mapper.CoursePersistenceMapper;
import com.exaginalCrud.demo.infrastructure.adapters.output.persistence.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistencePort {

    private final CourseRepository courseRepository;
    private final CoursePersistenceMapper persistenceMapper;

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id)
                .map(persistenceMapper::toCourse);
    }

    @Override
    public List<Course> findAll() {
        return persistenceMapper.toCourseList(courseRepository.findAll());
    }

    @Override
    public Course save(Course course) {
        return persistenceMapper.toCourse(
                courseRepository.save(persistenceMapper.toCourseEntity(course))
        );
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
