package com.misha.schoolmicroservice.controller;

import com.misha.schoolmicroservice.entity.School;
import com.misha.schoolmicroservice.jwt.JwtUtils;
import com.misha.schoolmicroservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    @PostMapping
    public School addSchool(@RequestBody School school){

        System.out.println(school);
        encoder.encode(school.getPassword());
        return schoolService.addSchool(school);
    }
    @GetMapping
    public List<School> fetchSchools(){
        return  schoolService.fetchSchools();
    }
    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable Long id){
        return schoolService.fetchSchoolById(id);
    }
}
