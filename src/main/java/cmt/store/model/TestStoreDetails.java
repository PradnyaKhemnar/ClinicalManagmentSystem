package cmt.store.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cmt.report.model.Report;
import cmt.testdetails.model.TestDetails;
@Entity
@Table(name="placingtest")
public class TestStoreDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int placeTestId;

private String testName;

private String testType;

private double testPrice;

public int getPlaceTestId() {
	return placeTestId;
}

public void setPlaceTestId(int placeTestId) {
	this.placeTestId = placeTestId;
}

public String getTestName() {
	return testName;
}

public void setTestName(String testName) {
	this.testName = testName;
}

public String getTestType() {
	return testType;
}

public void setTestType(String testType) {
	this.testType = testType;
}

public double getTestPrice() {
	return testPrice;
}

public void setTestPrice(double testPrice) {
	this.testPrice = testPrice;
}

@JsonIgnore
@ManyToOne
private TestDetails tes;

public TestDetails getTes() {
	return tes;
}



public void setTes(TestDetails tes) {
	this.tes = tes;
}


@OneToOne(cascade = CascadeType.ALL)

private Report rep;

public Report getRep() {
	return rep;
}

public void setRep(Report rep) {
	this.rep = rep;
}

public TestStoreDetails(int placeTestId, String testName, String testType, double testPrice, TestDetails tes,
		Report rep) {
	super();
	this.placeTestId = placeTestId;
	this.testName = testName;
	this.testType = testType;
	this.testPrice = testPrice;
	this.tes = tes;
	this.rep = rep;
}

public TestStoreDetails() {
	super();
	// TODO Auto-generated constructor stub
}





}
