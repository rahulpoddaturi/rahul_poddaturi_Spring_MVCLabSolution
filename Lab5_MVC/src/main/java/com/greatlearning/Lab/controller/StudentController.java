package com.greatlearning.Lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.Lab.entity.Student;
import com.greatlearning.Lab.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService  studentService;
	
	@RequestMapping("/list")
	public String listStudent(Model theModel) {

		// get Books from db
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);

		return "list-students";
	}
	@RequestMapping("/showFormForRegistration")
	public String showForm(Model theModel) {

		// create a student object
		Student theStudent = new Student();

		// add student object to the model
		theModel.addAttribute("Student", theStudent);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

		return "student-confirmation";
	}
	
	@PostMapping("/save")
	public String SaveStudent(@RequestParam("id") int id,
							  @RequestParam("FirstName") String firstname,
							  @RequestParam("LastName") String lastname,
							  @RequestParam("Department") String department,
							  @RequestParam("Country") String country) {

		System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstname);
			theStudent.setLastName(lastname);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(firstname,lastname,department,country);
		// save the Book
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Book
		studentService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/student/list";

	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,Model theModel) {

		// delete the Book
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("Student", theStudent);
		// redirect to /Books/list
		return "student-form";

	}


}
