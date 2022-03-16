package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="grievances")
public class GrievancesEntity {
	@Id
	@GeneratedValue
	@Column(name = "complaintId", nullable=false)
	private long complaintId;
	@Column(name="complaintMessage")
	@Size(max=100)
	private String complaintMessage;
	
	@ManyToOne
	private Farmer farmer;
	
	@ManyToOne
	private SupplierEntity suppliers;
	
	
	public GrievancesEntity() {
		
	}


	public GrievancesEntity(long complaintId, @Size(max = 100) String complaintMessage, Farmer farmer,
			SupplierEntity suppliers) {
		super();
		this.complaintId = complaintId;
		this.complaintMessage = complaintMessage;
		this.farmer = farmer;
		this.suppliers = suppliers;
	}


	public long getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(long complaintId) {
		this.complaintId = complaintId;
	}


	public String getComplaintMessage() {
		return complaintMessage;
	}


	public void setComplaintMessage(String complaintMessage) {
		this.complaintMessage = complaintMessage;
	}


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}


	public SupplierEntity getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(SupplierEntity suppliers) {
		this.suppliers = suppliers;
	}


	@Override
	public String toString() {
		return "GrievancesEntity [complaintId=" + complaintId + ", complaintMessage=" + complaintMessage + ", farmer="
				+ farmer + ", suppliers=" + suppliers + "]";
	}
	
}