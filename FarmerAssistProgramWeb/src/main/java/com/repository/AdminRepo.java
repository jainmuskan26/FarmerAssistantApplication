package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.entity.AdminEntity;
import com.entity.SupplierEntity;



@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Integer>

{
	@Query("Select a from AdminEntity a where a.adminUsername=?1 order by a.adminUsername")
	AdminEntity FindByadminUsername(String adminUsername);


	@Query("Select f from Farmer f where f.farmer_name=?1 order by f.farmer_name")

	AdminEntity FindByFarmer_name(String farmer_name);
	
	@Query("Select s from SupplierEntity s where s.supplierName=?1 order by s.supplierName")

	SupplierEntity FindBySupplierName(String supplierName);
	
	
	
	
	
	
	

}