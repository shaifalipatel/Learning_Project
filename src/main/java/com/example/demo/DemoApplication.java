package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.entity.Course;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

/*	@Autowired
	private EmployeeRepository employeeRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book saveBook = bookRepository.save(new Book( "SHaifali"));
		Book saveBook1 = bookRepository.save(new Book( "SpringBoot in 100 Step"));
		Book saveBook2 = bookRepository.save(new Book( "Hibernate In 50 step"));
		Book saveBook3 = bookRepository.save(new Book( "JPA Query"));
		logger.info("save book ->{}", saveBook);

		studentRepository.saveStudentWithPassport();
		courseRepository.save(new Course("Web Services in 100 step"));
		courseRepository.save(new Course("Spring  in 100 step"));
		courseRepository.save(new Course("Spring Boot in 100 step"));
		logger.info("course data save");

		courseRepository.addReviewForCourse();

/*		employeeRepository.insert(new PartTimeEmployee("Suhas", new BigDecimal("10000")));
		employeeRepository.insert(new FullTimeEmployee("Mansoor", new BigDecimal("50000")));
		employeeRepository.insert(new PartTimeEmployee("Sarvesh", new BigDecimal("100000")));
		employeeRepository.insert(new FullTimeEmployee("Kunal", new BigDecimal("200000")));
		logger.info("Employee inserted successfully");

		List<Employee> employeeList = employeeRepository.getEmployeeList();*/
	/*	logger.info("All employee details -> {}" + employeeList);*/

	}
}
