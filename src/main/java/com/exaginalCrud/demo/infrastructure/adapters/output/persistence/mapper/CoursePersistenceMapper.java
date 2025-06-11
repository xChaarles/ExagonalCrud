package com.exaginalCrud.demo.infrastructure.adapters.output.persistence.mapper;

import com.exaginalCrud.demo.domain.model.Course;
import com.exaginalCrud.demo.infrastructure.adapters.output.persistence.entity.CourseEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoursePersistenceMapper {
    CourseEntity toCourseEntity(Course course);
    Course toCourse(CourseEntity entity);
    List<Course> toCourseList(List<CourseEntity> entityList);
}
