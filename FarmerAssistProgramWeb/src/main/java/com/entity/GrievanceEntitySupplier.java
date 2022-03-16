package com.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	import javax.validation.constraints.Size;

	@Entity
	@Table(name="grievancesSupplier")
	public class GrievanceEntitySupplier {
		@Id
		@GeneratedValue
		@Column(name = "complaintIdSupplier", nullable=false)
		private long complaintIdSupplier;
		@Column(name="complaintMessageSupplier")
		@Size(max=100)
		private String complaintMessageSupplier;
		
	
		
		@ManyToOne
		private SupplierEntity suppliers;
		
		
		public GrievanceEntitySupplier() {
			
		}


		public GrievanceEntitySupplier(long complaintIdSupplier, @Size(max = 100) String complaintMessageSupplier,
				SupplierEntity suppliers) {
			super();
			this.complaintIdSupplier = complaintIdSupplier;
			this.complaintMessageSupplier = complaintMessageSupplier;
			this.suppliers = suppliers;
		}


		public long getComplaintIdSupplier() {
			return complaintIdSupplier;
		}


		public void setComplaintIdSupplier(long complaintIdSupplier) {
			this.complaintIdSupplier = complaintIdSupplier;
		}


		public String getComplaintMessageSupplier() {
			return complaintMessageSupplier;
		}


		public void setComplaintMessageSupplier(String complaintMessageSupplier) {
			this.complaintMessageSupplier = complaintMessageSupplier;
		}


		public SupplierEntity getSuppliers() {
			return suppliers;
		}


		public void setSuppliers(SupplierEntity suppliers) {
			this.suppliers = suppliers;
		}


		@Override
		public String toString() {
			return "GrievanceEntitySupplier [complaintIdSupplier=" + complaintIdSupplier + ", complaintMessageSupplier="
					+ complaintMessageSupplier + ", suppliers=" + suppliers + "]";
		}

			

		
}
