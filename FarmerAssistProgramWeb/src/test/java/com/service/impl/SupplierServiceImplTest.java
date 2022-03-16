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

import com.entity.SupplierEntity;
import com.repository.SupplierRepository;
import com.service.SupplierService;
@SpringBootTest
class SupplierServiceImplTest {
	
	@Autowired
	SupplierService supplierService;
	
	@MockBean
	SupplierRepository supplierRepository;
	
	
	@Test
	void testSaveSupplier() {
		SupplierEntity c1 = new SupplierEntity();
		c1.setSupplierId(1l);
		c1.setSupplierName("Aditya");
		c1.setSupplierPhone("9604422663");
		c1.setSupplierAddress("Pune");
		
		Mockito.when(supplierRepository.save(c1)).thenReturn(c1);
		
		assertThat(supplierService.saveSupplier(c1)).isEqualTo(c1);
	}

	@Test
	void testGetAllSupplier() {
		SupplierEntity c1 = new SupplierEntity();
		c1.setSupplierId(1l);
		c1.setSupplierName("Aditya");
		c1.setSupplierPhone("9604422663");
		c1.setSupplierAddress("Pune");
		
		SupplierEntity c2 = new SupplierEntity();
		c2.setSupplierId(2l);
		c2.setSupplierName("raju");
		c2.setSupplierPhone("9604422668");
		c2.setSupplierAddress("mumbai");
		
		SupplierEntity c3 = new SupplierEntity();
		c3.setSupplierId(3l);
		c3.setSupplierName("sumit");
		c3.setSupplierPhone("9604422669");
		c3.setSupplierAddress("banglore");
		
		List<SupplierEntity> supplierList= new ArrayList<>();
		supplierList.add(c1);
		supplierList.add(c2);
		supplierList.add(c3);
		
		Mockito.when(supplierRepository.findAll()).thenReturn(supplierList);
		
		assertThat(supplierService.getAllSupplier()).isEqualTo(supplierList);
		
	}

	@Test
	void testGetSupplierById() throws Throwable {
		
		SupplierEntity c1 = new SupplierEntity();
		c1.setSupplierId(3l);;
		c1.setSupplierName("Aditya");
		c1.setSupplierPhone("9604422663");
		c1.setSupplierAddress("Pune");
		
		
		Optional<SupplierEntity> c2= Optional.of(c1);
		
	    Mockito.when(supplierRepository.findById(3l)).thenReturn(c2);
	    
	    assertThat(supplierService.getSupplierById(3)).isEqualTo(c1);
		
		
	}

	@Test
	void testUpdateSupplier() throws Throwable {
		SupplierEntity c1 = new SupplierEntity();
		c1.setSupplierId(1l);
		c1.setSupplierName("Aditya");
		c1.setSupplierPhone("9604422663");
		c1.setSupplierAddress("Pune");
		
		Optional<SupplierEntity> c2= Optional.of(c1);
		
		Mockito.when(supplierRepository.findById(1l)).thenReturn(c2);
		
		Mockito.when(supplierRepository.save(c1)).thenReturn(c1);
		c1.setSupplierName("Madhulika");
		c1.setSupplierPhone("9096086669");
		c1.setSupplierAddress("Mumbai");
		
		assertThat(supplierService.updateSupplier(c1, 1l)).isEqualTo(c1);
	}

	@Test
	void testDeleteSupplier() {
		SupplierEntity c1 = new SupplierEntity();
		c1.setSupplierId(1l);
		c1.setSupplierName("Aditya");
		c1.setSupplierPhone("9604422663");
		c1.setSupplierAddress("Pune");
		Optional<SupplierEntity> c2=Optional.of(c1);
		
		Mockito.when(supplierRepository.findById(1l)).thenReturn(c2);
		Mockito.when(supplierRepository.existsById(c1.getSupplierId())).thenReturn(false);
		assertFalse(supplierRepository.existsById(c1.getSupplierId()));
		
		
	}

}
