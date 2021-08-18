package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entities.Student;

public interface StudentDao {
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int id);
	public Student getStudent(int id);
	public List<Student> getAllStudent();
}
