package com.managementstudents.repository;

import com.managementstudents.dto.StudentDTO;
import com.managementstudents.model.Gender;
import com.managementstudents.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<StudentDTO> findByFirstName(String firstName);

    Optional<StudentDTO> findByLastName(String lastName);

    Optional<StudentDTO> findByAge(int age);

    Optional<StudentDTO> findByGender(Gender gender);

    Optional<StudentDTO> findByEmail(String email);

    Optional<StudentDTO> findByDni(String dni);
}
