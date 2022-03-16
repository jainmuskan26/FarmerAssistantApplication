package com.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Crop;
import com.repository.CropRepo;

@SpringBootTest
class CropServiceTest 
{
	@ Autowired
    private CropService cropservice;
	@MockBean
	CropRepo repo; 


	@Test
	void testAddCrop() 
	{
		Crop c1=new Crop();
		c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		 Mockito.when(repo.save(c1)).thenReturn(c1);                        //save to repository

	        assertThat(cropservice.addCrop(c1)).isEqualTo(c1);            //checks the object
	}

	@Test
	void testGetCrops() 
	{
		Crop c1=new Crop();
		c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		
		Crop c2=new Crop();
		c2.setCropid(2);
		c2.setCropname("wheat");
		c2.setCropprice(87.74);
		c2.setCropquantity(79.05);
		
		List<Crop> cropList= new ArrayList<>();
        cropList.add(c1);
        cropList.add(c2);

		Mockito.when(repo.findAll()).thenReturn(cropList);                      

	        assertThat(cropservice.getCrops()).isEqualTo(cropList);   
		
		
	}

	@Test
	void testGetCropById() throws Throwable
	
	{
		Crop c1=new Crop();
		c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		
		
		Optional<Crop> c2= Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);

        assertThat(cropservice.getCropById(1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCropById() 
	{
		Crop c1=new Crop();
		c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		
		Optional<Crop> c2=Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);
        Mockito.when(repo.existsById(c1.getCropid())).thenReturn(false);
        assertFalse(repo.existsById(c1.getCropid()));
		
	}

	@Test
	void testDeleteCrop() 
	{
		Crop c1=new Crop();
		c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		
		Optional<Crop> c2=Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);
        Mockito.when(repo.existsById(c1.getCropid())).thenReturn(false);
        assertFalse(repo.existsById(c1.getCropid()));
		
	}

	@Test
	void testUpdateCrop()  throws Throwable 
	{
		Crop c1=new Crop();
		c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		
		Optional<Crop> c2= Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);
        
        Mockito.when(repo.save(c1)).thenReturn(c1);
        c1.setCropid(1);
		c1.setCropname("rice");
		c1.setCropprice(87.00);
		c1.setCropquantity(79.00);
		
		 assertThat(cropservice.updateCrop(c1)).isEqualTo(c1);
		
		
	}

}
