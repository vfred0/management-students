package com.managementstudents.dto;

import com.managementstudents.model.Gender;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Value
public class StudentDTO {
    @NotNull(message = "El id no puede ser nulo")
    int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    String firstName;

    @NotBlank(message = "El apellido no puede estar vacío")
    @NotNull(message = "El apellido no puede ser nulo")
    String lastName;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Email(message = "El correo electrónico no es válido")
    String email;

    @NotNull(message = "La edad no puede ser nula")
    @Positive(message = "La edad debe ser mayor a 0")
    @DecimalMax(value = "100", message = "La edad debe ser menor a 100 años")
    @DecimalMin(value = "1", message = "La edad debe ser mayor a 1 año")
    int age;

    @NotNull(message = "El dni no puede ser nulo")
    @Length(min = 10, max = 10, message = "El dni debe tener 10 dígitos")
    String dni;

    Gender gender;
}
