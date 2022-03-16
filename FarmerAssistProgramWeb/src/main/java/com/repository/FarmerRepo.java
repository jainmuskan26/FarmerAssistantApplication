package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.entity.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Integer>
{
	@Query("Select f from Farmer f where f.farmer_name=?1 order by f.farmer_name")
	List<Farmer> FindByFarmername(String farmer_name);
	@Query("Select f from Farmer f where f.farmer_contact_number=?1 order by f.farmer_contact_number")
	Farmer getFarmerByFarmercontactnumber(String farmer_contact_number);
	
	
}
