package com.misha.schoolmicroservice.security;

import com.misha.schoolmicroservice.entity.School;
import com.misha.schoolmicroservice.repository.SchoolRepository;
import com.sun.jdi.LongValue;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Long l= Long.parseLong(id);
        School school = schoolRepository.findById(l).get();
        System.out.println(school);

        if (school == null) {
            throw new UsernameNotFoundException("User not found with email: " + school.getSchoolName());
        }

        System.out.println("Loaded User: " + school.getSchoolName() + ", password hash: " + school.getPassword());
        return UserPrincipal.build(school);
    }


}
