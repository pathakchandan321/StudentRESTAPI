package com.chandanpathak2005.gmail.com.RestAPI.repository;

import com.chandanpathak2005.gmail.com.RestAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
