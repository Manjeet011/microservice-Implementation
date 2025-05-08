package com.misha.studentmicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private Integer schoolId;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Student() {
    }

    public Student(String name, int age, String gender, Integer schoolId, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.schoolId = schoolId;
        this.password = password;
    }

    public Student(String name, int age, String gender, Integer schoolId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.schoolId = schoolId;
    }
}
