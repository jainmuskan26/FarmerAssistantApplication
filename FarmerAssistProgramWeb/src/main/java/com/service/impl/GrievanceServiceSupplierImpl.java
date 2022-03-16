package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.GrievanceEntitySupplier;

import com.exception.ComplaintidNotFoundException;
import com.repository.GrievanceEntitySupplierRepo;
import com.service.GrievanceServiceSupplier;

@Service
public class GrievanceServiceSupplierImpl implements GrievanceServiceSupplier {
	
	@Autowired
	private GrievanceEntitySupplierRepo grievanceEntitySupplierRepo;

	

	public GrievanceServiceSupplierImpl(GrievanceEntitySupplierRepo grievanceEntitySupplierRepo) {
		super();
		this.grievanceEntitySupplierRepo = grievanceEntitySupplierRepo;
	}

	@Override
	public GrievanceEntitySupplier saveGrievancesSupplier(GrievanceEntitySupplier grievancesSupplier) {

		return grievanceEntitySupplierRepo.save(grievancesSupplier);
	}

	@Override
	public List<GrievanceEntitySupplier> getAllGrievancesSupplier() {

		return grievanceEntitySupplierRepo.findAll();
	}

	@Override
	public GrievanceEntitySupplier getGrievancesByIdSupplier(long id) throws Exception {
		

		return grievanceEntitySupplierRepo.findById(id).orElseThrow(() -> new ComplaintidNotFoundException("ComplaintId Not found"));
	}

	@Override
	public GrievanceEntitySupplier updateGrievancesSupplier(GrievanceEntitySupplier grievancesSupplier, long id) throws Throwable  {
		// check the exestng employee
		
		GrievanceEntitySupplier existingGrievances = grievanceEntitySupplierRepo.findById(id).orElseThrow(
				()-> new ComplaintidNotFoundException("Supplier Not found"));
		existingGrievances.setComplaintIdSupplier(grievancesSupplier.getComplaintIdSupplier());
		existingGrievances.setComplaintMessageSupplier(grievancesSupplier.getComplaintMessageSupplier());
		// save existing employee to database 
		grievanceEntitySupplierRepo.save(existingGrievances);
		
		return existingGrievances;
	}

	@Override
	public void deleteGrievanceSupplier(long id) throws Throwable  {
		// check whether a employee exists in a db or not 
		grievanceEntitySupplierRepo.findById(id).orElseThrow(()-> new ComplaintidNotFoundException("Compliant Not found"));
		grievanceEntitySupplierRepo.deleteById(id);
		
		
	}

}
