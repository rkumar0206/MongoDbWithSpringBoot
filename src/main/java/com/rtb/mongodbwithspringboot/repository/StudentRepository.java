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
}
