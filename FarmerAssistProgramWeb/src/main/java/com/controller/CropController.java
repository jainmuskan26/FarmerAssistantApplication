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

import com.entity.Crop;
import com.service.impl.CropService;
 
@RestController
@RequestMapping("/api")
public class CropController 
{
 
    
   @ Autowired
    private CropService cropservice;




    @GetMapping(path="/getCrops")
    public ResponseEntity <List<Crop>> getCrops()
    {
        List<Crop> lc1 = cropservice.getCrops();
        ResponseEntity re = new ResponseEntity<List<Crop>>(lc1,HttpStatus.OK);
        return re;
    }

    @GetMapping(path="/getCrop/{cropid}")
    public ResponseEntity <Crop> getCropById(@PathVariable int cropid) throws Throwable
    {
        Crop c1= cropservice.getCropById(cropid);
        ResponseEntity re = new ResponseEntity<Crop>(c1,HttpStatus.OK);
        return re;
    }
    @PostMapping(path="/addCrop")
    public ResponseEntity <Crop> addFarmer(@RequestBody Crop c) 
    {
        Crop c1 = cropservice.addCrop(c);
        ResponseEntity re = new ResponseEntity<Crop>(c1,HttpStatus.OK);
        return re;
    }
 
    

    @PutMapping(path="/updateCrop")
    public ResponseEntity<Crop> updateCrop(@RequestBody Crop e) throws Throwable 
    {
        Crop c2= cropservice.updateCrop(e);
        ResponseEntity re = new ResponseEntity<Crop>(c2,HttpStatus.OK);
        return re;
    }

    @DeleteMapping(path="/deleteCrop")
    public ResponseEntity <String> deleteCrop(@RequestBody Crop e) 
    {
        cropservice.deleteCrop(e);
        ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
        return re;
    }

    @DeleteMapping(path="/deleteCrop/{cropid}")
    public ResponseEntity <String> deleteCropById(@PathVariable int cropid) throws Throwable
    {
        cropservice.deleteCropById(cropid);
        ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
        return re;
    }    
}
    