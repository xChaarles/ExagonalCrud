package com.exaginalCrud.demo.application.service;

import com.exaginalCrud.demo.application.ports.input.StudentServicePort;
import com.exaginalCrud.demo.application.ports.output.CoursePersistencePort;
import com.exaginalCrud.demo.application.ports.output.StudentPersistencePort;
import com.exaginalCrud.demo.domain.exception.CourseNotFoundException;
import com.exaginalCrud.demo.domain.exception.StudentNotFoundException;
import com.exaginalCrud.demo.domain.model.Course;
import com.exaginalCrud.demo.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort persistencePort;
    private final CoursePersistencePort coursePersistencePort;

    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id)
                .map(student1 -> {
                    student1.setFirstname(student.getFirstname());
                    student1.setLastname(student.getLastname());
                    student1.setAge(student.getAge());
                    student1.setAddress(student.getAddress());
                    return persistencePort.save(student1);
                })
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (persistencePort.findById(id).isEmpty()){
            throw new StudentNotFoundException();
        }
        persistencePort.deleteById(id);
    }

    @Override
    public void addCourseToStudent(Long studentId, Long courseId) {
        Student student = persistencePort.findById(studentId)
                .orElseThrow(StudentNotFoundException::new);

        Course course = coursePersistencePort.findById(courseId)
                .orElseThrow(CourseNotFoundException::new);

        student.setCourse(course);
        persistencePort.save(student);
    }
}