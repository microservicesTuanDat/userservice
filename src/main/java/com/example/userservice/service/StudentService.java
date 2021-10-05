package com.example.userservice.service;

import com.example.userservice.VO.Khoa;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.Student;
import com.example.userservice.repository.StudentReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    @Autowired
    private StudentReposity studentReposity;
    @Autowired
    private RestTemplate restTemplate;

    public Student saveUser(Student user) {
        return studentReposity.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentReposity.findById(userId).get();
        vo.setUser(student);
        Khoa khoa =
                restTemplate.getForObject("http://localhost:9001/khoa/"
                                + student.getDepartmentId(),
                        Khoa.class);

        vo.setKhoa(khoa);

        return vo;
    }
}
