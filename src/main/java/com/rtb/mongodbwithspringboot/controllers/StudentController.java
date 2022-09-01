package com.rtb.mongodbwithspringboot.controllers;

import com.rtb.mongodbwithspringboot.entity.Student;
import com.rtb.mongodbwithspringboot.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable String id) {

        return studentService.getById(id);
    }

    @GetMapping("/all")
    private List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    private Student updateStudent(@RequestBody Student student) {

        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    private String deleteStudent(@PathVariable String id) {

        return studentService.deleteStudentById(id);
    }
}
