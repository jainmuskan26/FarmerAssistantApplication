package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="supplier")
public class SupplierEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long supplierId;
	
	@NotNull
    @Size(min = 2, message = "first Name should have at least 2 char")
	@Column(name = "supplier_name")
	private String supplierName;
	@NotNull 
	@Column(name="supplier_address")
	private String supplierAddress;
	@NotNull
	@Pattern(regexp="[7-9][0-9]{9}", message="Number must contains no. and length should be 10 ")
	@Column(name="supplier_number")
	private String supplierPhone;
	@JsonIgnore
	@OneToMany(mappedBy="supplier")
	private List<AdvertisementEntity> advertisement;
	
	@JsonIgnore
	@OneToMany(mappedBy="suppliers")
	private List<GrievanceEntitySupplier> grievancesSupplier;
	
	public SupplierEntity() {
		
	}

	public SupplierEntity(long supplierId,
			@NotNull @Size(min = 2, message = "first Name should have at least 2 char") String supplierName,
			@NotNull String supplierAddress,
			@NotNull @Pattern(regexp = "[7-9][0-9]{9}", message = "Number must contains no. and length should be 10 ") String supplierPhone,
			List<AdvertisementEntity> advertisement, List<GrievanceEntitySupplier> grievancesSupplier) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierPhone = supplierPhone;
		this.advertisement = advertisement;
		this.grievancesSupplier = grievancesSupplier;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public List<AdvertisementEntity> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(List<AdvertisementEntity> advertisement) {
		this.advertisement = advertisement;
	}

	public List<GrievanceEntitySupplier> getGrievancesSupplier() {
		return grievancesSupplier;
	}

	public void setGrievancesSupplier(List<GrievanceEntitySupplier> grievancesSupplier) {
		this.grievancesSupplier = grievancesSupplier;
	}

	@Override
	public String toString() {
		return "SupplierEntity [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierAddress="
				+ supplierAddress + ", supplierPhone=" + supplierPhone + ", advertisement=" + advertisement
				+ ", grievancesSupplier=" + grievancesSupplier + "]";
	}

	
	
	
	
	

}
