package com.rtb.mongodbwithspringboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    @Field(name = "mail")
    private String email;
    private Department department;
    private List<Subject> subjects;

    // transient means it will not be stored into the database, it will be there in json response
    @Transient
    private double percentage;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // whenever we have more than one constructor then we need to provide the @PersistenceCreator to our main constructor
    // Also we don't need to provide this annotation to it's sub document as they are not representing any collection
    @PersistenceCreator
    public Student(String id, String name, String email, Department department, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getPercentage() {

        if (subjects != null && subjects.size() > 0) {

            float total = 0.0f;

            for (Subject subject : subjects) {
                total += subject.getMarksObtained();
            }

            return total / subjects.size();
        }

        return 0.00;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
