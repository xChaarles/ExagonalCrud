package com.exaginalCrud.demo.infrastructure.adapters.output.persistence.repository;

import com.exaginalCrud.demo.infrastructure.adapters.output.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
