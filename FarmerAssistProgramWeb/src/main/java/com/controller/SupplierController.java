package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.entity.AdvertisementEntity;
import com.entity.SupplierEntity;
import com.service.AdvertisementService;
import com.service.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	
	@Autowired
	private AdvertisementService advertisementService;
	
	
	public SupplierController(SupplierService supplierService, AdvertisementService advertisementService) {
		super();
		this.supplierService = supplierService;
		this.advertisementService = advertisementService;
	}

	//build create supplier rest api
	@PostMapping("/save/supplier")
	public ResponseEntity<SupplierEntity> saveSupplier(@RequestBody SupplierEntity supplier)
	{
		return new ResponseEntity<SupplierEntity>(supplierService.saveSupplier(supplier), HttpStatus.CREATED);
	}
	
	//build all supplier REst api
	@GetMapping("/get/supplier")
	public List<SupplierEntity> getAllSupplier(){
		return supplierService.getAllSupplier();
	}	
	// get supplier by id 
	
	@GetMapping("/get/{id}")	
	public ResponseEntity<SupplierEntity> getSupplierById(@PathVariable("id") long supplierId) throws Throwable
	{
		return new ResponseEntity<SupplierEntity>(supplierService.getSupplierById(supplierId), HttpStatus.OK);
	}
	
	// update supplier rest api
	@PutMapping("/put/{id}")
	public ResponseEntity<SupplierEntity> updateSupplier(@PathVariable("id") long id, @RequestBody SupplierEntity supplier) throws Throwable{
		return new ResponseEntity<SupplierEntity>(supplierService.updateSupplier(supplier, id), HttpStatus.OK);
	}
	
	// delete 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("id") long id )throws Throwable{
		
		supplierService.deleteSupplier(id);
		
		return new ResponseEntity<String>("Supplier Deleted successfully", HttpStatus.OK);
		
	}
	
		
	//add advertisement
		@PostMapping("/add")
		public ResponseEntity<AdvertisementEntity> saveAdvertisement(@RequestBody AdvertisementEntity message){
			
			return new ResponseEntity<AdvertisementEntity>( advertisementService.saveAdvertisement(message), HttpStatus.OK);
		}
		//get all advertisement
		@GetMapping("/get")
		public List<AdvertisementEntity> getAllAdvr(){
			return advertisementService.getAllAdvr();
		}
		//delete add by id 
		@DeleteMapping("/add_delete/{id}")
		public ResponseEntity<String> deleteAdvertisement(@PathVariable("id") long id )throws Throwable{
			
			advertisementService.deleteAdvertisement(id);
			return new ResponseEntity<String>("Add Deleted successfully", HttpStatus.OK);
			
		}
		/*
		 * @GetMapping("/getAddbyId/{id}") public
		 * ResponseEntity<List<AdvertisementEntity>> getBySupplierId(@Param("id") long
		 * id){
		 * 
		 * 
		 * 
		 * return (ResponseEntity<List<AdvertisementEntity>>)
		 * advertisementService.getBySupplierId(id); }
		 */
}
