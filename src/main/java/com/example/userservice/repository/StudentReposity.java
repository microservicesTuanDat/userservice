package com.example.userservice.repository;

import com.example.userservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface StudentReposity extends JpaRepository<Student, Long> {


}
