package com.service;

import java.util.List;

import com.entity.SupplierEntity;

public interface SupplierService {
	
	SupplierEntity saveSupplier(SupplierEntity supplier);
	List<SupplierEntity> getAllSupplier();
	SupplierEntity getSupplierById(long id) throws Throwable ;
	SupplierEntity updateSupplier(SupplierEntity supplier, long id ) throws Throwable ;
	void deleteSupplier(long id) throws Throwable ;
	
}
