package com.managementstudents.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "students")
public class Student {
    @Id
    private UUID id;
    @Column(nullable = false, columnDefinition = "varchar(25)")
    private String firstName;
    @Column(nullable = false, columnDefinition = "varchar(25)")
    private String lastName;
    @Column(nullable = false, columnDefinition = "smallint")
    private int age;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
