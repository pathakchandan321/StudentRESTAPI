package com.chandanpathak2005.gmail.com.RestAPI.service;

import com.chandanpathak2005.gmail.com.RestAPI.dto.AddStudentRequestDto;
import com.chandanpathak2005.gmail.com.RestAPI.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getById(long id);
    StudentDto createBody(AddStudentRequestDto addStudentRequestDto);

    void deleteById(Long id);
}
