package com.spts.services;

import java.util.List;

import com.spts.model.Student;

public interface StudentServiceInterface {

    public List<Student> getAllStudents();
    Student getStudentById(int sid);
    public boolean updateStudentProfile(Student student);
}