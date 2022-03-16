package com.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.AdvertisementEntity;
import com.entity.SupplierEntity;
import com.exception.AddNotFoundException;
import com.exception.ResourceNotFoundException;
import com.repository.AdvertisementRepository;
import com.repository.SupplierRepository;
import com.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	private AdvertisementRepository advertisementRepository;
	@Autowired
	private SupplierRepository supplierRepository;

	public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository,
			SupplierRepository supplierRepository) {
		super();
		this.advertisementRepository = advertisementRepository;
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<AdvertisementEntity> getAllAdvr() {

		return advertisementRepository.findAll();
	}

	@Override
	public AdvertisementEntity saveAdvertisement(AdvertisementEntity message) {

		return advertisementRepository.save(message);
	}

	@Override
	public void deleteAdvertisement(long id) throws Throwable {
		advertisementRepository.findById(id).orElseThrow(() -> new AddNotFoundException("There is no Add"));
		advertisementRepository.deleteById(id);

	}

	/*@Override
	public List<AdvertisementEntity> getBySupplierId(long id) {
		
		List<AdvertisementEntity> list = advertisementRepository.findAll();
		List<AdvertisementEntity> list2= new ArrayList<>();
			Iterator e = list.iterator();
			while (e.hasNext()) {
				if(list.contains(id)) {
					list2.add((AdvertisementEntity) e.next());
				}
			}
		return list2;*/
	}

	
		

	
	


