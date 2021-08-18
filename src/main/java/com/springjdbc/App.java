package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //context.getBean(arg0);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        
        //INSERT
        /*Student student = new Student(1,"Amit","Delhi");
        student.setId(1);
        student.setName("Amit");
        student.setCity("Delhi");
        int r = studentDao.insertStudent(student);
        System.out.println("record inserted: "+r);*/
        
        
        //UPDATE
        /*student.setId(1);
        student.setName("Sumit");
        student.setCity("Gurugram");
        r = studentDao.updateStudent(student);
        System.out.println("record updated: "+r);*/
        
        
        /*int r = studentDao.deleteStudent(1);
        System.out.println("record deleted: "+r);*/
        
        
        
        
        //JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //System.out.println(context.getBeanDefinitionCount());
		/*
		 * String query="insert into student(name,city) values(?,?);"; int
		 * result = jdbcTemplate.update(query,"Amit","Howrah");
		 * System.out.println("record inserted: "+result);
		 */
        
        //Getting Singlr Object
        //Student student = studentDao.getStudent(2);
        //System.out.println(student);
        
        List<Student> students = studentDao.getAllStudent();
        for(Student s: students){
        	System.out.println(s);
        }
        
    }
}
