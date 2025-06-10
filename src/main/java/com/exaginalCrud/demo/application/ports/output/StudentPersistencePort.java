package com.exaginalCrud.demo.application.ports.output;

import com.exaginalCrud.demo.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {

    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);

}
