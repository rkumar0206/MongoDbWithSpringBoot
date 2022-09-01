package com.rtb.mongodbwithspringboot.entity;

import org.springframework.data.mongodb.core.mapping.Field;

// we don't need to annotate it with @Document as it is the sub document of the Student collection
public class Department {

    @Field(name = "department_name")
    private String departmentName;
    private String location;

    public Department() {}

    public Department(String departmentName, String location) {
        this.departmentName = departmentName;
        this.location = location;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
