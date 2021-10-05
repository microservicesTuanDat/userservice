package com.example.userservice.controller;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.Student;
import com.example.userservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
//@EnableEurekaClient
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveUser(@RequestBody Student student){

        return studentService.saveUser(student);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id")
                                                                Long userId){
        return studentService.getUserWithDepartment(userId);
    }

}
