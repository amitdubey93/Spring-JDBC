package com.springjdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.dao.RowMapperImpl;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertStudent(Student student) {
		String sql = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(sql, student.getId(), student.getName(), student.getCity());
		System.out.println("Data Inserted");
		return r;
	}

	public int updateStudent(Student student) {
		String sql = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(sql, student.getName(), student.getCity(),student.getId());
		System.out.println("Data Updated");
		return r;
	}

	public int deleteStudent(int id) {
		String sql = "delete from student where id=?";
		int r = this.jdbcTemplate.update(sql, id);
		System.out.println("Data Deleted");
		return r;
	}

	public Student getStudent(int id) {
		//select single object
		String sql="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		return student;
	}

	public List<Student> getAllStudent() {
		String sql="select * from student";
		List<Student> students = this.jdbcTemplate.query(sql, new RowMapperImpl());
		return students;
	}

}
