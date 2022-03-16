package com.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
@Entity
@Table(name = "admins")
public class AdminEntity { 
    @Id
    @GeneratedValue
    @Column(name = "adminId")
    private int adminId;

    @Column(name = "adminUsername")
    @NotNull(message="name cannot be null")
    @Size(max=10)
    private String adminUsername;
    
    
    @Column(name = "adminMail")
    @NotNull
    @Size(max=15 ,message="mail must contain upto 15 letters only")
    private String adminMail;
    
    public AdminEntity() {
    		// Default Constructor
    }
    
	public AdminEntity(int adminId, String adminUsername, String adminAdress,String adminMail) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminMail = adminMail;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getadminUsername() {
		return adminUsername;
	}
	public void setadminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminMail=" + adminMail + "]";
	}

}