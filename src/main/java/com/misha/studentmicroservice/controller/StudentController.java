package com.misha.studentmicroservice.controller;

import com.misha.studentmicroservice.entity.Student;
import com.misha.studentmicroservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable String id){

        System.out.println(id);
        return studentService.fetchStudentById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchStudents(){
        return studentService.fetchStudents();
    }
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        student.setPassword(encoder.encode(student.getPassword()));
        return studentService.createStudent(student);
    }
}
