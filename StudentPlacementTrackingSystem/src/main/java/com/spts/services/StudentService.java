package com.spts.services;

import java.util.List;

import com.spts.model.Student;
import com.spts.repository.StudentRepository;

public class StudentService implements StudentServiceInterface {

    StudentRepository repository = new StudentRepository();

    public List<Student> getAllStudents()
    {
        return repository.getAllStudents();
    }

	@Override
	public Student getStudentById(int sid) 
	{
		return repository.getStudentById(sid);
	}
	public boolean updateStudentProfile(Student student)
	{
	    return repository.updateStudentProfile(student);
	}
}