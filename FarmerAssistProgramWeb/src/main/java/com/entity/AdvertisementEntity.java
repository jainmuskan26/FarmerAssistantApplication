package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="advertisement")
public class AdvertisementEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long addId;
	@NotNull
	/* @Pattern(regexp="[a-zA-z]") */
	@Column(name="advertisementMessage")
	private String adver;
	
	@ManyToOne
	private SupplierEntity supplier;
	
	
	
	public AdvertisementEntity () {
		
	}



	public AdvertisementEntity(long addId,
			@NotNull /* @Pattern(regexp = "[a-zA-z]") */ String adver,
			SupplierEntity supplier) {
		super();
		this.addId = addId;
		this.adver = adver;
		this.supplier = supplier;
	}



	public long getAddId() {
		return addId;
	}



	public void setAddId(long addId) {
		this.addId = addId;
	}



	public String getAdver() {
		return adver;
	}



	public void setAdver(String adver) {
		this.adver = adver;
	}



	public SupplierEntity getSupplier() {
		return supplier;
	}



	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}



	@Override
	public String toString() {
		return "AdvertisementEntity [addId=" + addId + ", adver=" + adver + ", supplier=" + supplier + "]";
	}



	
	

}
