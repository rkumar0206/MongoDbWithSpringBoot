package com.rtb.mongodbwithspringboot.services;

import com.rtb.mongodbwithspringboot.entity.Student;
import com.rtb.mongodbwithspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public String deleteStudentById(String id) {

        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}
