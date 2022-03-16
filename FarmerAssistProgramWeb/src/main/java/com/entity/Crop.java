package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Crop 
{
	
	@Id
	@GeneratedValue
	private int cropid;
    @NotNull
    @Size(min = 2, message = "First Name should have at least 2 char")	
    
	private String cropname;
    @NotNull
	private double cropprice;
	@NotNull
	private double cropquantity;
	
	@ManyToOne
	private Farmer farmers;
	
	public Crop()
	{
		
	}


	public int getCropid() {
		return cropid;
	}


	public void setCropid(int cropid) {
		this.cropid = cropid;
	}


	public String getCropname() {
		return cropname;
	}


	public void setCropname(String cropname) {
		this.cropname = cropname;
	}


	public double getCropprice() {
		return cropprice;
	}


	public void setCropprice(double cropprice) {
		this.cropprice = cropprice;
	}


	public double getCropquantity() {
		return cropquantity;
	}


	public void setCropquantity(double cropquantity) {
		this.cropquantity = cropquantity;
	}


	@Override
	public String toString() {
		return "Crop [cropid=" + cropid + ", cropname=" + cropname + ", cropprice=" + cropprice + ", cropquantity="
				+ cropquantity + "]";
	}

	
}
	  
	