package com.managementstudents.service;

import com.managementstudents.dto.StudentDTO;
import com.managementstudents.model.Gender;
import com.managementstudents.model.Student;
import com.managementstudents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Optional<StudentDTO> findByFirstName(String firstName) {
        if (studentRepository.findByFirstName(firstName).isPresent()) {
            return studentRepository.findByFirstName(firstName);
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> findByLastName(String lastName) {
        if (studentRepository.findByLastName(lastName).isPresent()) {
            return studentRepository.findByLastName(lastName);
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> findByAge(int age) {
        if (studentRepository.findByAge(age).isPresent()) {
            return studentRepository.findByAge(age);
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> findByEmail(String email) {
        if (studentRepository.findByEmail(email).isPresent()) {
            return studentRepository.findByEmail(email);
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> findByGender(Gender gender) {
        if (studentRepository.findByGender(gender).isPresent()) {
            return studentRepository.findByGender(gender);
        }
        return Optional.empty(); 
    }

    @Override
    public Optional<StudentDTO> findByDni(String dni) {
        if (studentRepository.findByDni(dni).isPresent()) {
            return studentRepository.findByDni(dni);
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> findById(int id) {
        if (studentRepository.findById(id).isPresent()) {
            Student student = studentRepository.findById(id).get();
            return Optional.of(
                    new StudentDTO(
                            student.getId(),
                            student.getFirstName(),
                            student.getLastName(),
                            student.getEmail(),
                            student.getAge(),
                            student.getDni(),
                            student.getGender()));
        }
        return Optional.empty();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(int id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id).get();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());
        student.setGender(studentDTO.getGender());
        student.setDni(studentDTO.getDni());
        studentRepository.save(student);
    }

    @Override
    public int saveStudent(StudentDTO studentDTO) {
        Student student = Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .age(studentDTO.getAge())
                .email(studentDTO.getEmail())
                .dni(studentDTO.getDni())
                .gender(studentDTO.getGender()).build();
        return studentRepository.save(student).getId();
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                student.getDni(),
                student.getGender())).collect(Collectors.toList());
    }
}
