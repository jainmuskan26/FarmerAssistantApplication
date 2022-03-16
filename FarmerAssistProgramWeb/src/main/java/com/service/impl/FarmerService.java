package com.service.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exception.ResourceNotFoundException;

import com.entity.Farmer;
import com.repository.FarmerRepo;

@Service
public class FarmerService {
	
	@Autowired
	FarmerRepo repo; 
	
	public Farmer addFarmer(Farmer f)
	{
		 repo.save(f);	
		 return f;
	}
	public List<Farmer> getFarmers()
	{
		List<Farmer> lf1=repo.findAll();
		return lf1;
	}
	
	

		public Farmer getFarmerById(int farmer_id) throws Throwable
	{
		Supplier s1= ()->new ResourceNotFoundException("Farmer Does not exist in the database");
		Farmer f=repo.findById(farmer_id).orElseThrow(s1);
		return f;
	 }

		public String deleteFarmerById(int farmer_id) throws Throwable
		{
			repo.findById(farmer_id).orElseThrow(()-> new ResourceNotFoundException("Farmer Does not exist in the database"));
	        repo.deleteById(farmer_id);
	        return "Deleted";
		}
		
		public String deleteFarmer(Farmer f) 
	   {
			repo.delete(f);
			return "Deleted";
		}	
		
		
		public Farmer updateFarmer(Farmer f) throws Throwable
		{
			int id=f.getFarmer_id();
			Supplier s1= ()->new ResourceNotFoundException("Farmer Does not exist in the database");
			Farmer f1=repo.findById(id).orElseThrow(s1);
			f1.setFarmer_name(f.getFarmer_name());
			f1.setFarmer_address(f.getFarmer_address());
			f1.setFarmer_contact_number(f.getFarmer_contact_number());
			repo.save(f1);
			return f1;
		}

		public List<Farmer> getFarmerByFarmername (String farmer_name)
		  { 
			 List<Farmer>  f=repo.FindByFarmername(farmer_name); 
			  return f;
		  }
		public Farmer getFarmerByFarmercontactnumber (String farmer_contact_number)
		{
			Farmer f=repo.getFarmerByFarmercontactnumber(farmer_contact_number);
			return f;
		}
		
		
}
	
