package com.rtb.mongodbwithspringboot.repository;

import com.rtb.mongodbwithspringboot.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    // instead of list if we return one student and if the mongo db fetches more than one document then it with throw query exception
    List<Student> findByNameAndEmail(String name, String email);
    List<Student> findByNameOrEmail(String name, String email);

    // to understand how to get documents using sub-document field
    // this is the native query for below : { "department.department_name" : "[DEPARTMENT_NAME]"}
    List<Student> findByDepartmentDepartmentName(String departmentName);

    // to understand how to get documents using array value
    // native query : {"subjects.subject_name" : "[SUBJECT_NAME]"}
    List<Student> findBySubjectsSubjectName(String subjectName);

    // to understand Like query
    // native query : { "mail" : /yahoo/ }
    // OR
    // internal modification : { "mail" : { "$regularExpression" : { "pattern" : "yahoo", "options" : ""}}}
    List<Student> findByEmailIsLike(String email);

    // to understand starts with query
    // native query : { "name" : /^Raj/ }
    // internal call query : { "name" : { "$regularExpression" : { "pattern" : "^Raj", "options" : ""}}}
    List<Student> findByNameStartsWith(String name);
}
