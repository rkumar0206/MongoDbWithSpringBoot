package com.rtb.mongodbwithspringboot.repository;

import com.rtb.mongodbwithspringboot.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {


}
