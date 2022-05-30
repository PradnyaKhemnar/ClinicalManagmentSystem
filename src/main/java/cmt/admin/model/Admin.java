package cmt.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ClinicAdmin")

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@Column(name = "adminName",nullable = false)
	@NotEmpty
	@Size(min = 2,max = 30,message = "Name Should be Length of 2-30.")
	private String adminName;
	@NotEmpty
	private String adminAddress;
	@NotEmpty
	@Size(min = 9,max = 30,message = "email Should be Length of 9-30.")
	private String adminEmail;
	@NotNull
	@Min(10)
	private long mobilenumber;
	@NotEmpty
	@Size(min = 4,max = 10,message = "UserName Should be Length of 4-10.")
	private String adminUserName;
	@NotEmpty
	@Size(min = 6,max = 10,message = "Password Should be Length of 6-10.")
	private String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId,String adminName,String adminAddress,String adminEmail,long mobilenumber,String adminUserName,String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminAddress = adminAddress;
		this.adminEmail = adminEmail;
		this.mobilenumber = mobilenumber;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminAddress=" + adminAddress
				+ ", adminEmail=" + adminEmail + ", mobilenumber=" + mobilenumber + ", adminUserName=" + adminUserName
				+ ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	
		
	

}
