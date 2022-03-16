package com.service;

import java.util.List;

import com.entity.GrievancesEntity;


public interface GrievancesService {
	
	GrievancesEntity saveGrievances(GrievancesEntity grievances);
	List<GrievancesEntity> getAllGrievances();
	GrievancesEntity getGrievancesById(long id) throws Throwable ;
	GrievancesEntity updateGrievances(GrievancesEntity grievances, long id ) throws Throwable ;
	void deleteGrievances(long id) throws Throwable ;

}