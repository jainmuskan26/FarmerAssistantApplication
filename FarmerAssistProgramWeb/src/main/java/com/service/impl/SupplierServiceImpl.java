package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.SupplierEntity;

import com.exception.ResourceNotFoundException;
import com.repository.SupplierRepository;
import com.service.SupplierService;

@Service
public class SupplierServiceImpl   implements SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;

	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public SupplierEntity saveSupplier(SupplierEntity supplier) {

		return supplierRepository.save(supplier);
	}

	@Override
	public List<SupplierEntity> getAllSupplier() {

		return supplierRepository.findAll();
	}

	@Override
	public SupplierEntity getSupplierById(long id) throws Exception {
		/*
		 * Optional <SupplierEntity> supplier = supplierRepository.findById(id);
		 * if(supplier.isPresent()) { return supplier.get(); } else { throw new
		 * ResourceNotFoundException("Supplier", "Id", id); }
		 */

		return supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier Not found"));
	}

	@Override
	public SupplierEntity updateSupplier(SupplierEntity supplier, long id) throws Throwable  {
		// check the exestng employee
		
		SupplierEntity existingSupplier = supplierRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Supplier Not found"));
		existingSupplier.setSupplierName(supplier.getSupplierName());
		existingSupplier.setSupplierAddress(supplier.getSupplierAddress());
		existingSupplier.setSupplierPhone(supplier.getSupplierPhone());
		// save existing employee to database 
		supplierRepository.save(existingSupplier);
		
		return existingSupplier;
	}

	@Override
	public void deleteSupplier(long id) throws Throwable  {
		// check whether a employee exists in a db or not 
		supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supplier Not found"));
		supplierRepository.deleteById(id);
		
		
	}

}
