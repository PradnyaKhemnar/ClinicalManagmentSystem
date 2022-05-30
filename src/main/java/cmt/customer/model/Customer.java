package cmt.customer.model;



import java.util.ArrayList;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cmt.test.model.Test;
import cmt.testdetails.model.TestDetails;



@Entity
@Table(name = "clinicCust")
public class Customer {

@Id
private String customerId;
@Column(name = "customerName", nullable = false)
@NotEmpty
@Size(min = 2, max = 10, message = "CustomerName Should be Length of 2-10.")
private String customerName;



@NotNull
@Min(10)
private long customerMobileNumber;



@NotEmpty
@Email
@Size(min = 9, max = 30, message = "CustomerEmail Should be Length of 9-30.")
private String customerEmail;



@Column(name = "customerAddress", nullable = false)
@NotEmpty
private String customerAddress;



@Size(min = 6, message = "Password Not Valid and Minimum length should be 6.")
private String customerPassword;



public String getCustomerId() {
return customerId;
}



public void setCustomerId(String customerId) {
this.customerId = customerId;
}



public String getCustomerName() {
return customerName;
}



public void setCustomerName(String customerName) {
this.customerName = customerName;
}



public long getCustomerMobileNumber() {
return customerMobileNumber;
}



public void setCustomerMobileNumber(long customerMobileNumber) {
this.customerMobileNumber = customerMobileNumber;
}



public String getCustomerEmail() {
return customerEmail;
}



public void setCustomerEmail(String customerEmail) {
this.customerEmail = customerEmail;
}



public String getCustomerAddress() {
return customerAddress;
}



public void setCustomerAddress(String customerAddress) {
this.customerAddress = customerAddress;
}



public String getCustomerPassword() {
return customerPassword;
}



public void setCustomerPassword(String customerPassword) {
this.customerPassword = customerPassword;
}



/*
* public Customer(String customerId, String customerName, long
* customerMobileNumber, String customerEmail, String customerAddress, String
* customerPassword) { super(); this.customerId = customerId; this.customerName
* = customerName; this.customerMobileNumber = customerMobileNumber;
* this.customerEmail = customerEmail; this.customerAddress = customerAddress;
* this.customerPassword = customerPassword; }
*/

public Customer() {
super();
// TODO Auto-generated constructor stub
}

@JsonIgnore
@OneToMany(mappedBy = "cus",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<TestDetails> test = new ArrayList<TestDetails>();



public List<TestDetails> getTest() {
return test;
}



public void setTest(List<TestDetails> test) {
this.test = test;
}


@Override
public String toString() {
return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNumber="
+ customerMobileNumber + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
+ ", customerPassword=" + customerPassword + "]";
}











}