package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.DTO.AnalysticResponse;

@Service
public class AnalyticsService {
	

	@Autowired
	private RestTemplate restTemplate;
	
	public AnalysticResponse collectData() {
		Long students= restTemplate.getForObject("http://student-service/internal/count", Long.class);
		Long recruiters= restTemplate.getForObject("http://recruiter-service/internal/count", Long.class);
		Long jobPosts= restTemplate.getForObject("http://jobPost-service/internal/count", Long.class);
		Long applications= restTemplate.getForObject("http://applcation-service/internal/count", Long.class);
		Long auth=restTemplate.getForObject("http://auth-service/internal/count", Long.class);
		Long admins=restTemplate.getForObject("http://admin-service/internal/count", Long.class);
		String email=restTemplate.getForObject("http://email-service/internal/count", String.class);
		String fileUpload=restTemplate.getForObject("http://admin-service/internal/count", String.class);
		return new AnalysticResponse(students,recruiters,jobPosts,applications,admins,email,fileUpload);
	}
}

