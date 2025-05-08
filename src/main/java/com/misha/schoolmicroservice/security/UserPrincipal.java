package com.misha.schoolmicroservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.misha.schoolmicroservice.entity.School;
import io.jsonwebtoken.lang.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String schoolName;

    private String location;

    @JsonIgnore
    private String principalName;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String schoolName, String location, String principalName
                        ) {
        this.id = id;
        this.schoolName = schoolName;
        this.location = location;
        this.principalName = principalName;

    }

    public static UserPrincipal build(School school) {



        System.out.println( "Id"+school.getId()+
                "SchoolName"+  school.getSchoolName()+"Location"+
                school.getLocation()+     // email
                "PrincipalName"+     school.getPrincipalName()
                );

        return new UserPrincipal(
                school.getId(),
                school.getSchoolName(),    // username
                school.getLocation(),       // email
                school.getPrincipalName()

        );
    }


    public Long getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }


    public String getLocation() {
        return location;
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
        return schoolName;
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
