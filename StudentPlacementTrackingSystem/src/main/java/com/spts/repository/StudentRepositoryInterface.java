package com.spts.repository;

import java.util.List;

import com.spts.model.Student;

public interface StudentRepositoryInterface {

    public List<Student> getAllStudents();
    Student getStudentById(int sid);
    public boolean updateStudentProfile(Student student);
}