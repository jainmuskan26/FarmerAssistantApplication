package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Farmer {

	@Id
	@GeneratedValue
	private int farmer_id;
	
	@NotNull
	@Size(min = 2, message = "First Name should have at least 2 char")
	private String farmer_name;
	
	private String farmer_address;
	@NotNull
    @Pattern(regexp="[7-9][0-9]{9}", message="Number must contains no. and length should be 10 ")
	private String farmer_contact_number;
	
	@JsonIgnore
	@OneToMany(mappedBy="farmer")
	private List<GrievancesEntity> grevancesEntity;
	
	@JsonIgnore
	@OneToMany(mappedBy="farmers")
	private List<Crop> crop;
	
	public Farmer() {
		
	}

	public Farmer(int farmer_id,
			@NotNull @Size(min = 2, message = "First Name should have at least 2 char") String farmer_name,
			String farmer_address,
			@NotNull @Pattern(regexp = "[7-9][0-9]{9}", message = "Number must contains no. and length should be 10 ") String farmer_contact_number,
			List<GrievancesEntity> grevancesEntity) {
		super();
		this.farmer_id = farmer_id;
		this.farmer_name = farmer_name;
		this.farmer_address = farmer_address;
		this.farmer_contact_number = farmer_contact_number;
		this.grevancesEntity = grevancesEntity;
	}

	public int getFarmer_id() {
		return farmer_id;
	}

	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}


	public String getFarmer_name() {
		return farmer_name;
	}


	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}


	public String getFarmer_address() {
		return farmer_address;
	}


	public void setFarmer_address(String farmer_address) {
		this.farmer_address = farmer_address;
	}


	public String getFarmer_contact_number() {
		return farmer_contact_number;
	}


	public void setFarmer_contact_number(String farmer_contact_number) {
		this.farmer_contact_number = farmer_contact_number;
	}


	public List<GrievancesEntity> getGrevancesEntity() {
		return grevancesEntity;
	}

	public void setGrevancesEntity(List<GrievancesEntity> grevancesEntity) {
		this.grevancesEntity = grevancesEntity;
	}

	@Override
	public String toString() {
		return "Farmer [farmer_id=" + farmer_id + ", farmer_name=" + farmer_name + ", farmer_address=" + farmer_address
				+ ", farmer_contact_number=" + farmer_contact_number + ", grevancesEntity=" + grevancesEntity + "]";
	}




	
	

	
	  
	
}
