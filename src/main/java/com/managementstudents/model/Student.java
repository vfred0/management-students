package com.managementstudents.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_G", uniqueConstraints = {
        @UniqueConstraint(name = "uq_students_dni", columnNames = "dni"),
        @UniqueConstraint(name = "uq_students_email", columnNames = "email")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, columnDefinition = "varchar(25)")
    private String firstName;
    @Column(nullable = false, columnDefinition = "varchar(25)")
    private String lastName;
    @Column(nullable = false, columnDefinition = "smallint")
    private int age;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String email;
    @Column(nullable = false, columnDefinition = "varchar(10)")
    private String dni;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
