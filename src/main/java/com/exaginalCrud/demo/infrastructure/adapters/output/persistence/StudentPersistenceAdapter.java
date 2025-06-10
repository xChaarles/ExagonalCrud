package com.exaginalCrud.demo.infrastructure.adapters.output.persistence;

import com.exaginalCrud.demo.application.ports.output.StudentPersistencePort;
import com.exaginalCrud.demo.domain.model.Student;
import com.exaginalCrud.demo.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.exaginalCrud.demo.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper persistenceMapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id)
                .map(persistenceMapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return persistenceMapper.toStudentList(studentRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return persistenceMapper.toStudent(
                studentRepository.save(persistenceMapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
