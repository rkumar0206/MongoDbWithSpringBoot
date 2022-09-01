package com.rtb.mongodbwithspringboot;

import com.rtb.mongodbwithspringboot.entity.Department;
import com.rtb.mongodbwithspringboot.entity.Student;
import com.rtb.mongodbwithspringboot.entity.Subject;
import com.rtb.mongodbwithspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableMongoRepositories("com.rtb.mongodbwithspringboot.repository")
public class MongoDbWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbWithSpringBootApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void insertSampleRecords() {

//        List<Student> sampleStudents = getSampleStudents();
//        studentRepository.saveAll(sampleStudents);
    }

    private List<Student> getSampleStudents() {

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            Student student = new Student();

            student.setName("student-" + i + 1);
            student.setEmail(student.getName() + "@gmail.com");
            student.setDepartment(new Department("department-" + i + 1, "department_location" + i + 1));
            student.setSubjects(Arrays.asList(
                    new Subject("subject-" + i + new Random().nextInt(100),new Random().nextInt(100)),
                    new Subject("subject-" + i + new Random().nextInt(100),new Random().nextInt(100))
            ));

            students.add(student);
        }
        return students;
    }
}
