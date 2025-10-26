package com.chandanpathak2005.gmail.com.RestAPI.service.implimentation;

import com.chandanpathak2005.gmail.com.RestAPI.dto.AddStudentRequestDto;
import com.chandanpathak2005.gmail.com.RestAPI.dto.StudentDto;
import com.chandanpathak2005.gmail.com.RestAPI.entity.Student;
import com.chandanpathak2005.gmail.com.RestAPI.repository.StudentRepository;
import com.chandanpathak2005.gmail.com.RestAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return  students.stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
        //OR
        //return students.stream().map(student->new StudentDto(student.getId(), student.getName(),student.getEmail())).toList();
        //        return studentDto;
    }
    @Override
    public StudentDto getById(long id) {
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found with id:"+id));
        return modelMapper.map(student, StudentDto.class);

    }

    @Override
    public StudentDto createBody(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent=modelMapper.map(addStudentRequestDto,Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("student not exist with id: "+id);
        }
        studentRepository.deleteById(id);
    }
}
