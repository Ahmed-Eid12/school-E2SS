package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.PreviousJob;
import com.ahmedeid.securityandjwt.demo.repository.PreviousJobRepository;

@Service
public class PreviousJobService {

	@Autowired
	private PreviousJobRepository previousJobRepository;
	
	public PreviousJob saveNewPreJob(PreviousJob preJob) {
		return this.previousJobRepository.save(preJob);
	}
	
	public List<PreviousJob> saveNewPreJobList(List<PreviousJob> preJob) {
		return this.previousJobRepository.saveAll(preJob);
	}
	
}
