package com.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.AdminEntity;
import com.entity.Crop;
import com.entity.Farmer;
import com.entity.SupplierEntity;
import com.controller.*;
import com.service.*;

import com.service.impl.AdminService;
import com.service.impl.CropService;
import com.service.impl.FarmerService;
@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "*")
public class AdminController {
	


	@Autowired
	private AdminService adminservice;

	@Autowired
	private FarmerService farmerservice;
	
	@Autowired
	private SupplierService supplierService;
	
	

	public AdminController(AdminService adminservice, FarmerService farmerservice, SupplierService supplierService)
			{
		super();
		this.adminservice = adminservice;
		this.farmerservice = farmerservice;
		this.supplierService = supplierService;
		
	}

	@GetMapping(path="/getAdmin/{adminId}")
	public ResponseEntity <AdminEntity> getAdminById(@PathVariable int adminId) throws Throwable
	{
		AdminEntity a1 = adminservice.getAdminById(adminId);
		ResponseEntity re = new ResponseEntity<AdminEntity>(a1,HttpStatus.OK);
		return re;
	}

	@PostMapping(path="/addAdmin")
	public ResponseEntity <AdminEntity> addAdmin(@RequestBody AdminEntity a)
	{
		AdminEntity a1 = adminservice.addAdmin(a);
		ResponseEntity re = new ResponseEntity<AdminEntity>(a1,HttpStatus.OK);
		return re;
	}

	@PutMapping(path="/updateAdmin")
	public ResponseEntity<AdminEntity> updateAdmin(@RequestBody AdminEntity e) throws Throwable
	{
	AdminEntity e1=adminservice.updateAdmin(e);
	
	ResponseEntity re=new ResponseEntity<AdminEntity>(e1,HttpStatus.OK);
	return re;
	}
	@DeleteMapping(path="/deleteAdminById/{adminId}")
	public ResponseEntity <String> deleteAdminById(@PathVariable int adminId)
	{
		adminservice.deleteAdminById(adminId);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/admin/getFarmers")
	public ResponseEntity <List<Farmer>> getFarmers()
	{
		List<Farmer> lf1 = farmerservice.getFarmers();
		ResponseEntity re = new ResponseEntity<List<Farmer>>(lf1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/admin/updateFarmer")
	public ResponseEntity<Farmer> updateFarmer(@RequestBody Farmer e) throws Throwable 
	{
		Farmer f2 = farmerservice.updateFarmer(e);
		ResponseEntity re = new ResponseEntity<Farmer>(f2,HttpStatus.OK);
		return re;
	}
	
	  //
	  
		/*
		 * @DeleteMapping(path="/deleteFarmerById/{farmer_id}") public ResponseEntity
		 * <String> deleteFarmerById(@PathVariable int farmer_id) {
		 * adminservice.deleteFarmerById(farmer_id); ResponseEntity re = new
		 * ResponseEntity<String>("Deleted",HttpStatus.OK); return re; }
		 * 
		 * @GetMapping("/getFarmer/{farmer_name}") public ResponseEntity<AdminEntity>
		 * getFarmer(@PathVariable String farmer_name) { AdminEntity
		 * a=adminservice.getFarmer(farmer_name); ResponseEntity re =new
		 * ResponseEntity<AdminEntity>(a,HttpStatus.OK); return re; }
		 */
	  @GetMapping("/getsupplier/{supplierName}") 
	  public ResponseEntity<SupplierEntity> getSupplierByName(@PathVariable String supplierName) 
	  { SupplierEntity a=adminservice.getSupplierByName(supplierName); 
	  ResponseEntity re =new ResponseEntity<SupplierEntity>(a,HttpStatus.OK); 
	  return re;
	  }
	  
	/*
	 * @DeleteMapping(path="/deleteSupplierById/{supplierId}") public ResponseEntity
	 * <String> deleteSupplierById(@PathVariable int supplierId) {
	 * adminservice.deleteSupplierById(supplierId); ResponseEntity re = new
	 * ResponseEntity<String>("Deleted",HttpStatus.OK); return re; }
	 */
	


}







