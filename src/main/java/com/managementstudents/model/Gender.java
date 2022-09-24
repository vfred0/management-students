package com.managementstudents.model;


public enum Gender {
    FEMALE("Femenino"),
    MALE("Masculino");
    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
