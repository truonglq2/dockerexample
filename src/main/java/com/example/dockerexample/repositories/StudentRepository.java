package com.example.dockerexample.repositories;

import com.example.dockerexample.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
