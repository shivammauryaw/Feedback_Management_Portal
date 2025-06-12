package com.kiet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kiet.model.Feedback;
import com.kiet.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	private FeedbackRepository repository;

	public FeedbackService(FeedbackRepository repository) {
		super();
		this.repository = repository;
	
	}

	public List<Feedback> retrieveAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Feedback retrieveById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return repository.save(feedback);
	}

	public void removebyid(int id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
	}


	public List<String> getAllCourseIds() {
		return repository.findAll().stream()
	            .map(Feedback::getCourseId)
	            .distinct()
	            .collect(Collectors.toList());
	}
	

}
