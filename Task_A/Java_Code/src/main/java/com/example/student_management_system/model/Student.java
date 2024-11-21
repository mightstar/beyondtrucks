package com.example.student_management_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int studentId;
    private String name;
    private int age;
    private String sexuality;

    public Student() {}

    public Student(int studentId, String name, int age, String sexuality) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.sexuality = sexuality;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexuality() {
        return sexuality;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }
}
