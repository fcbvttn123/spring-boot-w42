package ca.sheridancollege.vutran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.vutran.beans.Student;
import ca.sheridancollege.vutran.repository.StudentRepo;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {
	
	private StudentRepo sr;
	
	@GetMapping("/")
	public String indexHTML(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", sr.findAll());
		return "index";
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
		student.setId(null);
		sr.save(student);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", sr.findAll());
		return "index";
	}
	
	@GetMapping("/findByName/{namePart}")
	public String findByName(Model model, @PathVariable("namePart") String namePart) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", sr.findByNameContainingOrderByName(namePart));
		return "index";
	}
	
}
