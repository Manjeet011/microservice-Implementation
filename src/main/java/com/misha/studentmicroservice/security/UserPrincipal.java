package com.misha.studentmicroservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.misha.studentmicroservice.entity.Student;
import io.jsonwebtoken.lang.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
public class UserPrincipal implements UserDetails{

    private static final long serialVersionUID = 1L;

    private String id;

    private String StudentName;

    private String gender;

    @JsonIgnore
    private String age;


    public UserPrincipal(String id, String StudentName, String age, String gender
                        ) {
        this.id = id;
        this.StudentName = StudentName;
        this.age = age;
        this.gender = gender;

    }

    public static UserPrincipal build(Student student) {



        System.out.println( "Id"+student.getId()+
                "StudentName"+  student.getName()+"Age"+
                        student.getAge()+     // email
                "Gender"+     student.getGender()
                );

        return new UserPrincipal(
                student.getId(),
                student.getName(),
                 String.valueOf(student.getAge()),// username
                student.getGender()     // email
        );
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return StudentName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserPrincipal user = (UserPrincipal) o;
        return Objects.nullSafeEquals(id, user.id);
    }


}
