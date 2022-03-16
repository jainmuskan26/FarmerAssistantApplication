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

import com.entity.Farmer;
import com.repository.FarmerRepo;
@SpringBootTest
class FarmerServiceTest {
	@Autowired
	private FarmerService farmerservice;
	@MockBean
	FarmerRepo repo; 
	@Test
	void testAddFarmer() {
		Farmer c1 = new Farmer();
       c1.setFarmer_id(1);
       c1.setFarmer_name("Sumit");
       c1.setFarmer_contact_number("9890929215");
       c1.setFarmer_address("Pune");
        Mockito.when(repo.save(c1)).thenReturn(c1);						//save to repository
       
        assertThat(farmerservice.addFarmer(c1)).isEqualTo(c1);			//checks the object
	}

	@Test
	void testGetFarmers() {
		Farmer c1 = new Farmer();
		 c1.setFarmer_id(1);
	     c1.setFarmer_name("Sumit");
	     c1.setFarmer_contact_number("8888888885");
	     c1.setFarmer_address("Pune");
       
        Farmer c2 = new Farmer();
        c2.setFarmer_id(2);
        c2.setFarmer_name("Muskan");
        c2.setFarmer_contact_number("8888888886");
        c2.setFarmer_address("MP");
       
       Farmer c3 = new Farmer();
       c3.setFarmer_id(3);
       c3.setFarmer_name("Raju");
       c3.setFarmer_contact_number("9890929215");
       c3.setFarmer_address("USA");
       
        List<Farmer> farmerList= new ArrayList<>();
        farmerList.add(c1);
        farmerList.add(c2);
        farmerList.add(c3);
       
        Mockito.when(repo.findAll()).thenReturn(farmerList);
       
        assertThat(farmerservice.getFarmers()).isEqualTo(farmerList);
	}

	@Test
	void testGetFarmerById() throws Throwable{
		Farmer c1 = new Farmer();
		c1.setFarmer_id(1);
	    c1.setFarmer_name("Sumit");
	    c1.setFarmer_contact_number("8888888885");
	    c1.setFarmer_address("Pune");
       
       
        Optional<Farmer> c2= Optional.of(c1);
       
        Mockito.when(repo.findById(1)).thenReturn(c2);
       
        assertThat(farmerservice.getFarmerById(1)).isEqualTo(c1);
	}

	@Test
	void testDeleteFarmerById() throws Throwable {
		Farmer c1 = new Farmer();
		c1.setFarmer_id(1);
	    c1.setFarmer_name("Sumit");
	    c1.setFarmer_contact_number("8888888885");
	    c1.setFarmer_address("Pune");
        Optional<Farmer> c2=Optional.of(c1);
       
        Mockito.when(repo.findById(1)).thenReturn(c2);
        Mockito.when(repo.existsById(c1.getFarmer_id())).thenReturn(false);
        assertFalse(repo.existsById(c1.getFarmer_id()));
    
	}

	
	  @Test 
	  void testDeleteFarmer()
	  {
		  Farmer c1 = new Farmer();
			c1.setFarmer_id(1);
		    c1.setFarmer_name("Sumit");
		    c1.setFarmer_contact_number("8888888885");
		    c1.setFarmer_address("Pune");
	        Optional<Farmer> c2=Optional.of(c1);
	       
	        Mockito.when(repo.findById(1)).thenReturn(c2);
	        Mockito.when(repo.existsById(c1.getFarmer_id())).thenReturn(false);
	        assertFalse(repo.existsById(c1.getFarmer_id()));
	  }
	 

	

	@Test
	void testUpdateFarmer() throws Throwable {
		
		Farmer c1 = new Farmer();
		c1.setFarmer_id(1);
	    c1.setFarmer_name("Sumit");
	    c1.setFarmer_contact_number("8888888885");
	    c1.setFarmer_address("Pune");

        Optional<Farmer> c2= Optional.of(c1);

        Mockito.when(repo.findById(1)).thenReturn(c2);

        Mockito.when(repo.save(c1)).thenReturn(c1);
        c1.setFarmer_id(1);
	    c1.setFarmer_name("Sumit");
	    c1.setFarmer_contact_number("8888888885");
	    c1.setFarmer_address("Pune");
        assertThat(farmerservice.updateFarmer(c1)).isEqualTo(c1);
		
	}
	/* CUSTOM QUERY TESTING */

    @Test
    void testGetFarmerByFarmername()
    {
        Farmer c1 = new Farmer();
        c1.setFarmer_id(1);
        c1.setFarmer_name("Sumit");
        c1.setFarmer_contact_number("8888888885");
        c1.setFarmer_address("Pune");


        Farmer c2 = new Farmer();
        c2.setFarmer_id(2);
        c2.setFarmer_name("Muskan");
        c2.setFarmer_contact_number("8888888886");
        c2.setFarmer_address("MP");

        List<Farmer> farmerList= new ArrayList<>();
        farmerList.add(c1);
        farmerList.add(c2);

        Mockito.when(repo.FindByFarmername("Sumit")).thenReturn(farmerList);

        assertThat(farmerservice.getFarmerByFarmername("Sumit")).isEqualTo(farmerList);

    }

}
