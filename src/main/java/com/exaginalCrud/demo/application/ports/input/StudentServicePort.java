package com.exaginalCrud.demo.application.ports.input;

import com.exaginalCrud.demo.domain.model.Course;
import com.exaginalCrud.demo.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

    Student findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Long id, Student student);

    void deleteById(Long id);
    void addCourseToStudent(Long studentId, Long courseId);

}
