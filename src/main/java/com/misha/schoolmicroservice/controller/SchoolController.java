package com.misha.schoolmicroservice.controller;

import com.misha.schoolmicroservice.entity.School;
import com.misha.schoolmicroservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school){

        System.out.println(school);
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
