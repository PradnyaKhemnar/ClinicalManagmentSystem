package cmt.test.model;
import java.util.ArrayList;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;



import cmt.testdetails.model.TestDetails;


@Component
@Entity
@Table(name = "clinictest")
public class Test {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int testId;






private String testName;

private String testType;

private double testPrice;



public int getTestId() {
return testId;
}



public void setTestId(int testId) {
this.testId = testId;
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



public Test(int testId, String testName, String testType, double testPrice) {
super();
this.testId = testId;
this.testName = testName;
this.testType = testType;
this.testPrice = testPrice;
}







@Override
public String toString() {
return "Test [testId=" + testId + ", testName=" + testName + ", testType=" + testType + ", testPrice="
+ testPrice + "]";
}



public Test() {
super();
// TODO Auto-generated constructor stub
}



}