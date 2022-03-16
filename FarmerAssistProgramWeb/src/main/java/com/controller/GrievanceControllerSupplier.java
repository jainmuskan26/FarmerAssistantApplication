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
	import com.entity.GrievanceEntitySupplier;
	import com.service.GrievanceServiceSupplier;



	@RestController
	@RequestMapping("/api")
	public class GrievanceControllerSupplier {
		
		
	    @Autowired
	    private GrievanceServiceSupplier grievancesServiceSupplier;
	    
	   
	       
	    
	 
	    public GrievanceControllerSupplier(GrievanceServiceSupplier grievancesServiceSupplier) {
			super();
			this.grievancesServiceSupplier = grievancesServiceSupplier;
		}

		//build create supplier rest api
	    @PostMapping("/save/supplier_grievances")
	    public ResponseEntity<GrievanceEntitySupplier> saveGrievancesSupplier(@RequestBody GrievanceEntitySupplier grievancesSupplier)
	    {
	        return new ResponseEntity<GrievanceEntitySupplier>(grievancesServiceSupplier.saveGrievancesSupplier(grievancesSupplier), HttpStatus.CREATED);
	    }

	    //build all supplier REst api
	    @GetMapping("/get/supplier_grievances")
	    public List<GrievanceEntitySupplier> getAllGrievancesSupplier(){
	        return grievancesServiceSupplier.getAllGrievancesSupplier();
	    }    
	    // get grievances by id 

	    @GetMapping("/get/supplier_complaint/{id}")    
	    public ResponseEntity<GrievanceEntitySupplier> getGrievancesByIdSupplier(@PathVariable("id") long grievancesIdSupplier) throws Throwable
	    {
	        return new ResponseEntity<GrievanceEntitySupplier>(grievancesServiceSupplier.getGrievancesByIdSupplier(grievancesIdSupplier), HttpStatus.OK);
	    }

	    // update grievances rest api
	    @PutMapping("/put/supplier_complaint/{id}")
	    public ResponseEntity<GrievanceEntitySupplier> updateGrievancesSupplier(@PathVariable("id") long id, @RequestBody GrievanceEntitySupplier grievancesSupplier) throws Throwable{
	        return new ResponseEntity<GrievanceEntitySupplier>(grievancesServiceSupplier.updateGrievancesSupplier(grievancesSupplier, id), HttpStatus.OK);
	    }

	    // delete 
	    @DeleteMapping("/delete/supplier_complaint/{id}")
	    public ResponseEntity<String> deleteGrievancesSupplier(@PathVariable("id") long id )throws Throwable{

	    	grievancesServiceSupplier.deleteGrievanceSupplier(id);

	        return new ResponseEntity<String>("Grievances Deleted successfully", HttpStatus.OK);

	    }

	
}
