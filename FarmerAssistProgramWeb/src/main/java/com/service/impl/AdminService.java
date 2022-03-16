package com.service.impl;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.exception.ResourceNotFoundException;





	import com.entity.AdminEntity;
import com.entity.SupplierEntity;
import com.repository.AdminRepo;



@Service
public class AdminService {

@Autowired
private AdminRepo repo;




	public AdminRepo getRepo() {
	return repo;
	}

	public void setRepo(AdminRepo repo) {
	this.repo = repo;
	}
	 //Add Admin
	public AdminEntity addAdmin(AdminEntity a)                  
	{
	repo.save(a);
	return a;
	}


	//Update Admins
	public AdminEntity updateAdmin(AdminEntity a) throws Throwable
	{     
	int id=a.getAdminId();
	
	Supplier s1= ()->new ResourceNotFoundException("Admin Does not exist in the database");
	AdminEntity a1=repo.findById(id).orElseThrow();
	
	a1.setadminUsername(a.getadminUsername());
		a1.setAdminMail(a.getAdminMail());
		repo.save(a1);
		return a1;	
}


	//getAdminById
	public AdminEntity getAdminById(int adminId) throws Throwable    
	{
		Supplier s1= ()->new ResourceNotFoundException("Admin Does not exist in the database");
		AdminEntity a=repo.findById(adminId).orElseThrow();
		return a;
	}

	//deleteAdminById
	public String deleteAdminById(int adminId) 
	{        
	repo.deleteById(adminId);
	return "Deleted";
	}


	//deleteFarmerById
	public String deleteFarmerById(int farmer_id) {        
	repo.deleteById(farmer_id);
	return "Deleted";
	}


	//deleteSupplierById
	public String deleteSupplierById(int supplierId) {        
	repo.deleteById(supplierId);
	return "Deleted";
	}

	public AdminEntity getFarmer(String farmer_name)
	{
    AdminEntity f=repo.FindByFarmer_name(farmer_name);
    return f;
	}


	public SupplierEntity getSupplierByName(String supplierName)
	{
    SupplierEntity s=repo.FindBySupplierName(supplierName);
    return s;
	}





}












