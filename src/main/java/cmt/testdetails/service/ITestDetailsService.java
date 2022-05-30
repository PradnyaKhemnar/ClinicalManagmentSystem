package cmt.testdetails.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cmt.testdetails.model.TestDetails;
public interface ITestDetailsService { 
	public TestDetails addTestDetails(TestDetails td);
public TestDetails updateTestDetails(TestDetails td);
public List<TestDetails> deleteTestDetailsByCustId(String customerId);
public List<TestDetails> deleteTestDetailsByTestId(int testId);
public List<TestDetails> getTestDetailsByCustomerId(String customerId);
public List<TestDetails> getTestDetailsByTestId(int testId);
public List<TestDetails> getallTestDetails();
public List<TestDetails> deletetestDetailsByCustomerIdAndTestId(String customerId,int TestId);
public TestDetails deleteTestdetails(int testDetailsId);
public TestDetails getTestDetailsById(int testDetailsId);
public TestDetails getTestbytestid(int testdetailsid);
public int getfindamount(TestDetails t);
}

