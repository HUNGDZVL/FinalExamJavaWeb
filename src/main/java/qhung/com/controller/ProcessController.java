package qhung.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import qhung.com.model.Course;
import qhung.com.model.Professor;
import qhung.com.model.RegisterForm;
import qhung.com.repository.CourseRepository;
import qhung.com.repository.ProfessorRepository;

@Controller
public class ProcessController {
	private ProfessorRepository professorRepository; 
	private CourseRepository courseRepository; 
	public ProcessController( ProfessorRepository professorRepository, CourseRepository courseRepository) {
		this.professorRepository = professorRepository;
		this.courseRepository = courseRepository;
	}

	@GetMapping("/register")
	public String register( Model model) {
		List<Professor> professors = professorRepository.findAll();
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("professors", professors);
		model.addAttribute("courses", courses);
		return "register";
	}
	@PostMapping("/register")
	public String saveRegister( @ModelAttribute("RegisterForm") @RequestBody RegisterForm registerForm) {
		if(registerForm != null) {
			Course course = courseRepository.findById(registerForm.getCourseNo()).get();
			Professor professor = professorRepository.findById(registerForm.getProfNo()).get();
			if(course != null) { 
				if(professor != null) {
					course.setProfessor(professor);
					courseRepository.save(course);
				}
			}
		}
		return "home";
	}
	@GetMapping("/list")
	public String showProfessorList( Model model) {
		List<Professor> professors = professorRepository.findAll();
		model.addAttribute("professors", professors);
		return "professor-list";
	}
	@PostMapping("/list")
	public String showCourseListOfProfessor( @ModelAttribute("RegisterForm") @RequestBody RegisterForm registerForm, Model model) {
		if(registerForm != null) {
			Professor professor = professorRepository.findById(registerForm.getProfNo()).get();
				if(professor != null) {
					List<Course> courses = courseRepository.findAll();
					List<Course> coursesResults = new ArrayList<>();
				    for (Course course : courses) {
						if(course.getProfessor().getProfNo().equals(registerForm.getProfNo())) {
							coursesResults.add(course);
						}
					}
					model.addAttribute("courses", coursesResults);
				}
		}
		return "course-list";
	}
	@GetMapping("/course/delete/{id}")
	public String showProfessorList( @PathVariable("id") String courseNo) {
		Course course = courseRepository.findById(courseNo).get();
		Course course2 = new Course();
		course2.setCourseNo(course.getCourseNo());
		course2.setCourseName(course.getCourseName());
		if(course != null) {
			courseRepository.delete(course);
			courseRepository.save(course2);
		}
		return "home";
	}
} 
