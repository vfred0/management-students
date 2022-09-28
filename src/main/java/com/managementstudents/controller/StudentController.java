package com.managementstudents.controller;

import com.managementstudents.dto.StudentDTO;
import com.managementstudents.model.Gender;
import com.managementstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> findById(@PathVariable int studentId) {
        return this.studentService.findById(studentId)
                .map(studentDTO ->
                        new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> saveStudent(@Valid @RequestBody StudentDTO studentDTO) {
        int studentId = this.studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(this.getHeader(studentId), HttpStatus.CREATED);
    }

    private HttpHeaders getHeader(int studentId) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentId)
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", location.toString());
        return headers;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<HttpStatus> updateStudent(@PathVariable int studentId, @RequestBody StudentDTO studentDTO) {
        this.studentService.updateStudent(studentId, studentDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int studentId) {
        this.studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<StudentDTO> findByFirstName(@PathVariable String firstName) {
        return this.studentService.findByFirstName(firstName)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<StudentDTO> findByLastName(@PathVariable String lastName) {
        return this.studentService.findByLastName(lastName)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<StudentDTO> findByAge(@PathVariable int age) {
        return this.studentService.findByAge(age)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDTO> findByEmail(@PathVariable String email) {
        return this.studentService.findByEmail(email)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<StudentDTO> findByGender(@PathVariable Gender gender) {
        return this.studentService.findByGender(gender)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<StudentDTO> findByDni(@PathVariable String dni) {
        return this.studentService.findByDni(dni)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
