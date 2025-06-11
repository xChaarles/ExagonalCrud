package com.exaginalCrud.demo.infrastructure.adapters.input.rest.mapper;

import com.exaginalCrud.demo.domain.model.Course;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request.CourseCreateRequest;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseRestMapper {

    Course toCourse(CourseCreateRequest request);
    CourseResponse toCourseResponse(Course course);
    List<CourseResponse> toCourseResponseList(List<Course> courseList);

}
