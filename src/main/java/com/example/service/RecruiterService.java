package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.RecruiterDTO;
import com.example.entity.Recruiter;
import com.example.repository.RecruiterRepository;

@Service
public class RecruiterService {

	@Autowired
	private RecruiterRepository recruiterRepository;
	
	
	public RecruiterDTO createRecruiter(RecruiterDTO dto) {
		Recruiter recruiter = new Recruiter(dto.id,dto.name,dto.email,dto.phone,dto.companyName,dto.companyDescription,dto.companyWebsite);
		recruiter=recruiterRepository.save(recruiter);
	//	dto.setId(recruiter.getId());
		return dto;
	}
	public RecruiterDTO getRecruiterByEmail(String email) {
		Recruiter recruiter = recruiterRepository.findByEmail(email);
		if(recruiter == null)return null;
		return new RecruiterDTO(
				recruiter.getId(),
				recruiter.getName(),
				recruiter.getEmail(),recruiter.getPhone(),recruiter.getCompanyName(),recruiter.getCompanyDescription(),recruiter.getCompanyWebsite());	
		
	}
	public RecruiterDTO getRecruiterById(Long id) {
		Optional<Recruiter> recruiter=recruiterRepository.findById(id);
		if (!recruiter.isPresent()) return null;
		Recruiter rec=recruiter.get();
		return new RecruiterDTO(
			    rec.getId(), 
			    rec.getName(), 
			    rec.getEmail(), 
			    rec.getPhone(), 
			    rec.getCompanyName(), 
			    rec.getCompanyDescription(), 
			    rec.getCompanyWebsite());

		
		
	}
}
