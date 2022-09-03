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

    @GetMapping("/studentsByName/{name}")
    private List<Student> getByStudentName(@PathVariable String name) {

        return studentService.getByNameUsingNativeQuery(name);
    }

    @GetMapping("/studentByNameAndEmail")
    private List<Student> getByNameAndEmail(@RequestParam String name, @RequestParam String email) {

        return studentService.getByNameAndEmail(name, email);
    }

    @GetMapping("/studentByNameOrEmail")
    private List<Student> getByNameOrEmail(@RequestParam String name, @RequestParam String email) {

        return studentService.getByNameOrEmail(name, email);
    }

    @GetMapping("/allWithPagination")
    private List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {

        return studentService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/allWithSorting")
    private List<Student> getAllWithSorting() {

        return studentService.getAllWithSorting();
    }

    @GetMapping("/paginationAndSortingTogether")
    private List<Student> getAllWithPaginationAndSorting(@RequestParam int pageNo, @RequestParam int pageSize) {

        return studentService.getAllWithPaginationAndSorting(pageNo, pageSize);
    }

    @GetMapping("/byDepartmentName")
    private List<Student> getByDepartmentName(@RequestParam String departmentName) {

        return studentService.getByDepartmentName(departmentName);
    }

    @GetMapping("/bySubjectName")
    private List<Student> getBySubjectName(@RequestParam String subjectName) {

        return studentService.getBySubjectName(subjectName);
    }

    @GetMapping("/emailLike")
    private List<Student> getByEmailLike(@RequestParam String email) {

        return studentService.getByEmailLike(email);
    }

    @GetMapping("/nameStartsWith")
    private List<Student> getByNameStartWith(@RequestParam String name) {

        return studentService.getByNameStartsWith(name);
    }

}
