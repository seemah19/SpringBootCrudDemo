package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
		//	createStudent(studentDAO);

		//	readStudent(studentDAO);
		//	readStudentByLastName(studentDAO);

		//	queryForStudents(studentDAO);

		//	updateStudent(studentDAO);

			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id= 5;
		studentDAO.delete(id);
		System.out.println("student deleted with "+id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId= 1;
		System.out.println("getting student with "+studentId);

		Student student=studentDAO.findById(studentId);

		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("update student "+student);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findAll();
		for(Student student: theStudent){
			System.out.println(student);
		}
	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Mani");
		System.out.println(studentList);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("RAvi","totaki","ravi@gmail.com");
		studentDAO.save(student);
		System.out.println("Student saved " +student.getId());
		int id = student.getId();
		Student student1 = studentDAO.findById(id);
		System.out.println("the student is "+student1);

	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("nila","krita","seema@gamil.com");
		studentDAO.save(student);
		System.out.println("saved student "+student.getId());
	}
}
