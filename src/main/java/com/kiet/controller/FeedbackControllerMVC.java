package com.kiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiet.model.Feedback;
import com.kiet.service.FeedbackService;

@Controller
public class FeedbackControllerMVC {
	
	private FeedbackService service;

	public FeedbackControllerMVC(FeedbackService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(path= {"feedbacks","/"})
	public String getAllFeedbacks(Model model) {
		model.addAttribute(service.retrieveAll());
		return "index";
	}
	
	@GetMapping("/feedback/{id}")
	public String getFeedback(Model model,@PathVariable int id) {
		Feedback feedback = service.retrieveById(id);
		model.addAttribute("feedback", feedback);
		return "single";
	}
	
	@GetMapping("/addFeedback")
	public String addFeedback(Model model) {
		model.addAttribute("feedback",new Feedback());
		return "update";
	}
	
	@PostMapping("/save")
	public String insertStudent(@ModelAttribute Feedback feedback) {
		service.addFeedback(feedback);
		return "redirect:/";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String addStudent(Model model, @PathVariable int id) {
		Feedback feedback = service.retrieveById(id);
		model.addAttribute("feedback", feedback);
		return "update";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(Model model, @PathVariable int id) {
		service.removebyid(id);
		return "redirect:/";
	}
	
	@GetMapping("/feedback/courses")
	public String showAllCourses(Model model) {
	    model.addAttribute("courses", service.getAllCourseIds());
	    return "courses"; // This will be the new template name
	}
	
	
}
