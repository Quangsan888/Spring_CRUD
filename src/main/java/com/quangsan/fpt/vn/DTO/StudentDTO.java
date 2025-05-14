package com.quangsan.fpt.vn.DTO;

import jakarta.persistence.Column;

public class StudentDTO {

    private String name;
    private int grade;

    public StudentDTO(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
