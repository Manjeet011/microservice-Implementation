package com.misha.schoolmicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String schoolName;
    private String location;
    private String principalName;

    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public School() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public School(String schoolName, String location, String principalName, String password) {
        this.schoolName = schoolName;
        this.location = location;
        this.principalName = principalName;
        this.password = password;
    }

    public School(String schoolName, String location, String principalName) {
        this.schoolName = schoolName;
        this.location = location;
        this.principalName = principalName;
    }
}
