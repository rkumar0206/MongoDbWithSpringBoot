package com.rtb.mongodbwithspringboot.services;

import com.rtb.mongodbwithspringboot.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    Student getById(String id);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
    String deleteStudentById(String id);
}
