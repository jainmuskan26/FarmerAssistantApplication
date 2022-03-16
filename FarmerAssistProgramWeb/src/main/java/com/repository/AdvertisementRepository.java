package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AdvertisementEntity;

public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long>{
	
	

}
