package com.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import com.entity.AdminEntity;
import com.repository.AdminRepo;

	@SpringBootTest
	class AdminServiceTest {
		@Autowired
		private AdminService adminservice;
		@MockBean
		AdminRepo repo;
		@Test

		void testAddAdmin() {
			AdminEntity c1 = new AdminEntity();
			c1.setAdminId(1);
			c1.setadminUsername("Aditya");
			c1.setAdminMail("adi@gmail");
			Mockito.when(repo.save(c1)).thenReturn(c1);
			assertThat(adminservice.addAdmin(c1)).isEqualTo(c1);
		}



		@Test
		void testUpdateAdmin() throws Throwable{
			AdminEntity c1 = new AdminEntity();
			c1.setAdminId(1);
			c1.setadminUsername("sumit");
			c1.setAdminMail("Sumit@gmail");
			Optional<AdminEntity> c2= Optional.of(c1);
			Mockito.when(repo.findById(1)).thenReturn(c2);
			Mockito.when(repo.save(c1)).thenReturn(c1);
			c1.setadminUsername("Madhulika");
			c1.setAdminMail("Madhu@gmail");
			assertThat(adminservice.updateAdmin(c1)).isEqualTo(c1);
		}



		@Test
		void testGetAdminById() throws Throwable{
			AdminEntity c1 = new AdminEntity();
			c1.setAdminId(1);;
			c1.setadminUsername("Usman");
			c1.setAdminMail("Usman@gamil");
			Optional<AdminEntity> c2= Optional.of(c1);
			Mockito.when(repo.findById(1)).thenReturn(c2);
			assertThat(adminservice.getAdminById(1)).isEqualTo(c1);
}



		@Test
		void testDeleteAdminById() {
			AdminEntity c1 = new AdminEntity();
			c1.setAdminId(1);
			c1.setadminUsername("Raju");
			c1.setAdminMail("raju@gmail");
			Optional<AdminEntity> c2=Optional.of(c1);
			Mockito.when(repo.findById(1)).thenReturn(c2);
			Mockito.when(repo.existsById(c1.getAdminId())).thenReturn(false);
			assertFalse(repo.existsById(c1.getAdminId()));
}
}

