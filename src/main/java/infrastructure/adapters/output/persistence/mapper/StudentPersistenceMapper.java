package infrastructure.adapters.output.persistence.mapper;

import domain.model.Student;
import infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity entity);
    List<Student> toStudentList(List<StudentEntity> entityList);
}
