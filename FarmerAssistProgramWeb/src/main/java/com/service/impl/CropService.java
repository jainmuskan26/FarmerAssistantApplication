package com.service.impl;
 
import java.util.List;
import java.util.function.Supplier;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exception.ResourceNotFoundException;
import com.entity.Crop;
import com.repository.CropRepo;
 

 
@Service
public class CropService 
{

    @Autowired
    CropRepo repo; 

    public Crop addCrop(Crop c)
    {
         repo.save(c);    
         return c;
    }
    public List<Crop> getCrops()
    {
        List<Crop> lc1=repo.findAll();
        return lc1;
    }
 
        public Crop getCropById(int cropid) throws Throwable
    {
        Supplier s1= ()->new ResourceNotFoundException("Crop Does not exist in the database");
        Crop c=repo.findById(cropid).orElseThrow(s1);
        return c;
     }
 
        public String deleteCropById(int cropid) throws Throwable
        {
            repo.findById(cropid).orElseThrow(()-> new ResourceNotFoundException("Crop Does not exist in the database"));
            repo.deleteById(cropid);
            return "Deleted";
        }

        public String deleteCrop(Crop c) 
       {
            repo.delete(c);
            return "Deleted";
        }    
       

        public Crop updateCrop(Crop c) throws Throwable
        {
            int id=c.getCropid();
            Supplier s1= ()->new ResourceNotFoundException("Crop Does not exist in the database");
            Crop c1=repo.findById(id).orElseThrow(s1);
            c1.setCropname(c.getCropname());
            c1.setCropprice(c.getCropprice());
            c1.setCropquantity(c.getCropquantity());
            repo.save(c1);
            return c1;
        }
        
}
