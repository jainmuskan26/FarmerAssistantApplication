package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.GrievancesEntity;
import com.exception.ComplaintidNotFoundException;
import com.repository.GrievancesRepository;
import com.service.GrievancesService;


@Service
public class GrievancesServiceImpl   implements GrievancesService {
	@Autowired
	private GrievancesRepository grievancesRepository;

	public GrievancesServiceImpl(GrievancesRepository grievancesRepository) {
		super();
		this.grievancesRepository = grievancesRepository;
	}

	@Override
	public GrievancesEntity saveGrievances(GrievancesEntity grievances) {

		return grievancesRepository.save(grievances);
	}

	@Override
	public List<GrievancesEntity> getAllGrievances() {

		return grievancesRepository.findAll();
	}

	@Override
	public GrievancesEntity getGrievancesById(long id) throws Exception {
		/*
		 * Optional <SupplierEntity> supplier = supplierRepository.findById(id);
		 * if(supplier.isPresent()) { return supplier.get(); } else { throw new
		 * ResourceNotFoundException("Supplier", "Id", id); }
		 */

		return grievancesRepository.findById(id).orElseThrow(() -> new ComplaintidNotFoundException("ComplaintId Not found"));
	}

	@Override
	public GrievancesEntity updateGrievances(GrievancesEntity grievances, long id) throws Throwable  {
		// check the exestng employee
		
		GrievancesEntity existingGrievances = grievancesRepository.findById(id).orElseThrow(
				()-> new ComplaintidNotFoundException("Supplier Not found"));
		existingGrievances.setComplaintId(grievances.getComplaintId());
		existingGrievances.setComplaintMessage(grievances.getComplaintMessage());
		// save existing employee to database 
		grievancesRepository.save(existingGrievances);
		
		return existingGrievances;
	}

	@Override
	public void deleteGrievances(long id) throws Throwable  {
		// check whether a employee exists in a db or not 
		grievancesRepository.findById(id).orElseThrow(()-> new ComplaintidNotFoundException("Compliant Not found"));
		grievancesRepository.deleteById(id);
		
		
	}

}