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
import com.entity.GrievancesEntity;
import com.service.GrievancesService; 
@RestController
@RequestMapping("/api")
public class GrievancesController {
    @Autowired
    private GrievancesService grievancesService;
    
  
   
    public GrievancesController(GrievancesService grievancesService) {
        super();
        this.grievancesService = grievancesService;
       
    }
 
    //build create supplier rest api
    @PostMapping("/save/grievances")
    public ResponseEntity<GrievancesEntity> saveGrievances(@RequestBody GrievancesEntity grievances)
    {
        return new ResponseEntity<GrievancesEntity>(grievancesService.saveGrievances(grievances), HttpStatus.CREATED);
    }

    //build all supplier REst api
    @GetMapping("/get/grievances")
    public List<GrievancesEntity> getAllGrievances(){
        return grievancesService.getAllGrievances();
    }    
    // get grievances by id 

    @GetMapping("/get/complaint/{id}")    
    public ResponseEntity<GrievancesEntity> getGrievancesById(@PathVariable("id") long grievancesId) throws Throwable
    {
        return new ResponseEntity<GrievancesEntity>(grievancesService.getGrievancesById(grievancesId), HttpStatus.OK);
    }

    // update grievances rest api
    @PutMapping("/put/complaint/{id}")
    public ResponseEntity<GrievancesEntity> updateGrievances(@PathVariable("id") long id, @RequestBody GrievancesEntity grievances) throws Throwable{
        return new ResponseEntity<GrievancesEntity>(grievancesService.updateGrievances(grievances, id), HttpStatus.OK);
    }

    // delete 
    @DeleteMapping("/delete/complaint/{id}")
    public ResponseEntity<String> deleteGrievances(@PathVariable("id") long id )throws Throwable{

    	grievancesService.deleteGrievances(id);

        return new ResponseEntity<String>("Grievances Deleted successfully", HttpStatus.OK);

    }

}