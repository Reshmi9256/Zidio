package com.example.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.AnalysticResponse;
import com.example.service.AnalyticsService;

@RestController
@RequestMapping("/api/analystics")
public class AnalyticsController {
	
	@Autowired
	private AnalyticsService analyticsService;
	
	@GetMapping("/summery")
	public ResponseEntity<AnalysticResponse> getSummey(){
	return ResponseEntity.ok(analyticsService.collectData());
	}

}

