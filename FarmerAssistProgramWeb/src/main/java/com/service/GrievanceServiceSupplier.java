package com.service;

import java.util.List;

import com.entity.GrievanceEntitySupplier;

public interface GrievanceServiceSupplier {

	GrievanceEntitySupplier saveGrievancesSupplier(GrievanceEntitySupplier grievances);
	List<GrievanceEntitySupplier> getAllGrievancesSupplier();
	GrievanceEntitySupplier getGrievancesByIdSupplier(long id) throws Throwable ;
	GrievanceEntitySupplier updateGrievancesSupplier(GrievanceEntitySupplier grievances, long id ) throws Throwable ;
	void deleteGrievanceSupplier(long id) throws Throwable ;

}
