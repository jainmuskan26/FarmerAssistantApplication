package com.service;

import java.util.List;



import com.entity.AdvertisementEntity;



public interface AdvertisementService {
	
	public AdvertisementEntity saveAdvertisement(AdvertisementEntity message);
	public List<AdvertisementEntity> getAllAdvr();
	void deleteAdvertisement(long id) throws Throwable;
	
	
}
