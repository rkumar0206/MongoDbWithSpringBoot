package com.rtb.mongodbwithspringboot.services;

import com.rtb.mongodbwithspringboot.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    Student getById(String id);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
    String deleteStudentById(String id);
    List<Student> getByName(String name);
    List<Student> getByNameAndEmail(String name, String email);
    List<Student> getByNameOrEmail(String name, String email);
    List<Student> getAllWithPagination(int pageNo, int pageSize);
    List<Student> getAllWithSorting();
    List<Student> getAllWithPaginationAndSorting(int pageNo, int pageSize);
    List<Student> getByDepartmentName(String departmentName);  // to understand how to get document using sub-document field
    List<Student> getBySubjectName(String subjectName); // to understand how to get documents using array value
    List<Student> getByEmailLike(String email); //  to understand like query
    List<Student> getByNameStartsWith(String name); //  to understand startsWith query
}
