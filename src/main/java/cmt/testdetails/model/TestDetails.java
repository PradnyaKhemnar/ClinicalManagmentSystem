package cmt.testdetails.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cmt.customer.model.Customer;
import cmt.store.model.TestStoreDetails;
import cmt.test.model.Test;

@Entity
@Table(name="ClinicTestDetails")
public class TestDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int testDetailsId;
	
	 @JsonFormat(pattern="yyyy-MM-dd")
    private Date AppointmentDate;
	private String typeOfService;
	
	public int getTestDetailsId() {
		return testDetailsId;
	}
	public void setTestDetailsId(int testDetailsId) {
		this.testDetailsId = testDetailsId;
	}
	public Date getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getTypeOfService() {
		return typeOfService;
	}
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "tes",cascade  = CascadeType.ALL,fetch    = FetchType.EAGER)
	
	
	private List<TestStoreDetails> test=new ArrayList<TestStoreDetails>();//this should be mentioned in one to many of student to be mapped by property
	public List<TestStoreDetails> getTest() {
		return test;
		
		
	}
	public void setTest(List<TestStoreDetails> test) {
		this.test = test;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customid")
	
	private Customer cus;// this should be mentioned in one to many of student to be mapped by property



	public Customer getCus() {
	return cus;
	}



	public void setCus(Customer cus) {
	this.cus = cus;
	}
	public TestDetails(int testDetailsId, Date appointmentDate, String typeOfService, List<TestStoreDetails> test,
			Customer cus) {
		super();
		this.testDetailsId = testDetailsId;
		AppointmentDate = appointmentDate;
		this.typeOfService = typeOfService;
		this.test = test;
		this.cus = cus;
	}
	public TestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	

	
	
	 
	 

}
