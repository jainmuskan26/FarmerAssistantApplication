package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.entity.Farmer;

import com.repository.FarmerRepo;

import com.service.impl.FarmerService;

@RestController
@RequestMapping("/api")
public class FarmerController {

	
	@Autowired
	private FarmerService farmerservice;

	
	 @Autowired 
	 FarmerRepo repo;
	 
	@PostMapping(path="/addFarmer")
	public ResponseEntity <Farmer> addFarmer(@RequestBody Farmer f) 
	{
		Farmer f1 = farmerservice.addFarmer(f);
		ResponseEntity re = new ResponseEntity<Farmer>(f1,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getFarmers")
	public ResponseEntity <List<Farmer>> getFarmers()
	{
		List<Farmer> lf1 = farmerservice.getFarmers();
		ResponseEntity re = new ResponseEntity<List<Farmer>>(lf1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getFarmer/{farmer_id}")
	public ResponseEntity <Farmer> getFarmerById(@PathVariable int farmer_id) throws Throwable
	{
		Farmer f1 = farmerservice.getFarmerById(farmer_id);
		ResponseEntity re = new ResponseEntity<Farmer>(f1,HttpStatus.OK);
		return re;
	}
	
	// Custom Query 
	
	   @GetMapping("/getFarmerByname/{farmer_name}") 
	  public List<Farmer> getFarmerByFarmername (@PathVariable String farmer_name)
	   { 
		  List<Farmer>  lf2=farmerservice.getFarmerByFarmername(farmer_name); 
		  return lf2; 
		  }

	   @GetMapping("/getFarmerByContactNumber/{farmer_contact_number}") 
	   public ResponseEntity <Farmer> getFarmerByFarmercontactnumber(@PathVariable String farmer_contact_number)
		   { 
			 Farmer c= farmerservice.getFarmerByFarmercontactnumber(farmer_contact_number);
			 ResponseEntity re = new ResponseEntity<Farmer>(c,HttpStatus.OK);
			 return re;
			  }
	
	@PutMapping(path="/updateFarmer")
	public ResponseEntity<Farmer> updateFarmer(@RequestBody Farmer e) throws Throwable 
	{
		Farmer f2 = farmerservice.updateFarmer(e);
		ResponseEntity re = new ResponseEntity<Farmer>(f2,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteFarmer")
	public ResponseEntity <String> deleteFarmer(@RequestBody Farmer e) 
	{
		farmerservice.deleteFarmer(e);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteFarmer/{farmer_id}")
	public ResponseEntity <String> deleteFarmerById(@PathVariable int farmer_id) throws Throwable
	{
		farmerservice.deleteFarmerById(farmer_id);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
   
    
	}
	

