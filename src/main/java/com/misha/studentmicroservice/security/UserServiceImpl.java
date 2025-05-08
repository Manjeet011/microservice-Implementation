package com.misha.studentmicroservice.security;

import com.misha.studentmicroservice.entity.Student;
import com.misha.studentmicroservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {


        Student student = studentRepository.findById(id).get();
        System.out.println(student);

        if (student == null) {
            throw new UsernameNotFoundException("User not found with email: " + student.getName());
        }

        //System.out.println("Loaded User: " + student.getName() + ", password hash: " + school.getPassword());
        return UserPrincipal.build(student);
    }


}
