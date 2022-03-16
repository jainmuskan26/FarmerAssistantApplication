package com.service.impl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.entity.GrievancesEntity;
import com.repository.GrievancesRepository;
import com.service.GrievancesService;
@SpringBootTest
class GrievancesServiceTest {
@Autowired
private GrievancesService grievancesService;
	
	@MockBean
	GrievancesRepository repo;
	@Test
	void testgetAllGrievances() {
		GrievancesEntity c1 = new GrievancesEntity();
		c1.setComplaintId(1);
		c1.setComplaintMessage("Complaintt");
	}
	@Test
	void testGetGrievancesById() throws Throwable {
		GrievancesEntity c1 = new GrievancesEntity();
      c1.setComplaintId(1l);
      c1.setComplaintMessage("Complaintt");
        Optional<GrievancesEntity> c2= Optional.of(c1);
        Mockito.when(repo.findById(1l)).thenReturn(c2);
        assertThat(grievancesService.getGrievancesById(1l)).isEqualTo(c1);
	}
	@Test
	void testUpdateGrievances() throws Throwable {
		GrievancesEntity c1 = new GrievancesEntity();
		c1.setComplaintId(1l);
		c1.setComplaintMessage("Complaintt");      

        Optional<GrievancesEntity> c2= Optional.of(c1);

        Mockito.when(repo.findById(1l)).thenReturn(c2);

        Mockito.when(repo.save(c1)).thenReturn(c1);
        c1.setComplaintId(1l);
		c1.setComplaintMessage("Complaintt");

        assertThat(grievancesService.updateGrievances(c1, 1l)).isEqualTo(c1);
	}
    @Test
	void testDeleteGrievances() {
		GrievancesEntity c1 = new GrievancesEntity();
		c1.setComplaintId(1l);
		c1.setComplaintMessage("Complaintt");

        Optional<GrievancesEntity> c2=Optional.of(c1);

        Mockito.when(repo.findById(1l)).thenReturn(c2);
        Mockito.when(repo.existsById(c1.getComplaintId())).thenReturn(false);
        assertFalse(repo.existsById(c1.getComplaintId()));
	}
}
