package com.rtb.mongodbwithspringboot.services;

import com.rtb.mongodbwithspringboot.entity.Student;
import com.rtb.mongodbwithspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Student> getByName(String name) {

        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    @Override
    public List<Student> getByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllWithPagination(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        Page<Student> page = studentRepository.findAll(pageable);

        return page.getContent();
    }

    @Override
    public List<Student> getAllWithSorting() {

        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> getAllWithPaginationAndSorting(int pageNo, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getByDepartmentName(String departmentName) {

        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Student> getBySubjectName(String subjectName) {

        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    @Override
    public List<Student> getByEmailLike(String email) {

        return studentRepository.findByEmailIsLike(email);
    }

    @Override
    public List<Student> getByNameStartsWith(String name) {

        return studentRepository.findByNameStartsWith(name);
    }
}
