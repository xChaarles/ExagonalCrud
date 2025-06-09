package infrastructure.adapters.output.persistence;

import application.ports.output.StudentPersistencePort;
import domain.model.Student;
import infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.AllArgsConstructor;
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
