package com.managementstudents.service;

import com.managementstudents.dto.StudentDTO;
import com.managementstudents.model.Gender;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<StudentDTO> findByFirstName(String firstName);

    Optional<StudentDTO> findByLastName(String lastName);

    Optional<StudentDTO> findByAge(int age);

    Optional<StudentDTO> findByEmail(String email); 

    Optional<StudentDTO> findByGender(Gender gender);

    Optional<StudentDTO> findByDni(String dni);

    Optional<StudentDTO> findById(int id);

    void deleteStudent(int id);

    void updateStudent(int id, StudentDTO studentDTO);

    int saveStudent(StudentDTO studentDTO);


    List<StudentDTO> findAll();
}
