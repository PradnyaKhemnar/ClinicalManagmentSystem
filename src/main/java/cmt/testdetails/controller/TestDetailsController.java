package cmt.testdetails.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmt.customer.model.Customer;
import cmt.test.model.Test;
import cmt.testdetails.model.TestDetails;
import cmt.testdetails.service.TestDetailsService;

@RestController
public class TestDetailsController {
	
	
	@Autowired
	private TestDetailsService tdserv;
	
	@PostMapping("addTestDetails")
	public ResponseEntity<TestDetails> addTestDetails(@RequestBody TestDetails td,HttpServletRequest request) {
	//TestDetails t = tdserv.addTestDetails(td, ses);
	Customer c=(Customer) request.getSession().getAttribute("custuser");
	c.getTest().add(td);
	td.setCus(c);
	TestDetails t= tdserv.addTestDetails(td);
	request.getSession().setAttribute("testtdtest", td);
	System.out.println(td);
	if (t != null) {
	return new ResponseEntity<TestDetails>(t, HttpStatus.OK);
	} else {
	return new ResponseEntity<TestDetails>(t, HttpStatus.NOT_FOUND);
	}
	}
	
	@PutMapping("updateTestDetails")
	public ResponseEntity<TestDetails> updateTestDetails(@RequestBody TestDetails td,HttpServletRequest request)
	{
		TestDetails tdup=(TestDetails) request.getSession().getAttribute("testtdtest");
		
		tdup.setAppointmentDate(td.getAppointmentDate());
		tdup.setTypeOfService(td.getTypeOfService());
		TestDetails t=tdserv.updateTestDetails(tdup);
		if(t!=null)
				{
						return new ResponseEntity<TestDetails>(t,HttpStatus.NOT_FOUND);
				}
		else
				{
						return new ResponseEntity<TestDetails>(t,HttpStatus.OK);
				}
		
	}
	
	@DeleteMapping("deleteTestDetails/{testId}")
	public ResponseEntity<TestDetails> deleteTestDetails(@PathVariable("testId") int testdetailid)
	{
		TestDetails t=tdserv.deleteTestdetails(testdetailid);
		if(t!=null)
						{
								return new ResponseEntity<TestDetails>(t,HttpStatus.NOT_FOUND);
						}
		else
						{
								return new ResponseEntity<TestDetails>(t,HttpStatus.OK);
						}
	}
	
	@GetMapping("printTestDetails/{testDetailsId}")
	
	public ResponseEntity<TestDetails> printTestDetails(@PathVariable("testDetailsId") int testdetailsid)
	{
		TestDetails t=tdserv.getTestDetailsById(testdetailsid);
		if(t!=null)
						{
								return new ResponseEntity<TestDetails>(t,HttpStatus.NOT_FOUND);
						}
		else
						{
								return new ResponseEntity<TestDetails>(t,HttpStatus.FOUND);
						}
	}

	@GetMapping("printTestDetailsByCustId/{custId}")
	public ResponseEntity<List<TestDetails>> printTestDetailsByTestId(@PathVariable("custId") String custid)
	{
		List<TestDetails> lst=tdserv.getTestDetailsByCustomerId(custid);
				if(lst.isEmpty())
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.NOT_FOUND);
								}
				else
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.FOUND);
								}
	}
	@GetMapping("printTestDetailsByTestId/{testId}")
	public ResponseEntity<List<TestDetails>> printTestDetailsByTestId(@PathVariable("testId") int testid)
	{
		List<TestDetails> lst=tdserv.getTestDetailsByTestId(testid);
				if(lst.isEmpty())
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.NOT_FOUND);
								}
				else
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.FOUND);
								}
	}
	@DeleteMapping("deleteTestDetailsByTestId/{testId}")
	public ResponseEntity<List<TestDetails>> deleteTestDetailsByTestId(@PathVariable("testId") int testid)
	{
		List<TestDetails> lst=tdserv.deleteTestDetailsByTestId(testid);
				if(lst.isEmpty())
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.NOT_FOUND);
								}
				else
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.FOUND);
								}
	}

	@DeleteMapping("deleteTestDetailsByCustId/{custId}")
	public ResponseEntity<List<TestDetails>> deleteTestDetailsByTestId(@PathVariable("custId") String custid)
	{
		List<TestDetails> lst=tdserv.deleteTestDetailsByCustId(custid);
				if(lst.isEmpty())
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.NOT_FOUND);
								}
				else
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.FOUND);
								}
	}
	@DeleteMapping("deleteTestidandCustid/{testId}/{custId}")
	public ResponseEntity<List<TestDetails>> deleteTestDetailsByTestIdAndCustId(@PathVariable("custId") String custid,@PathVariable("testId") int testid)
	{
		List<TestDetails> lst=tdserv.deletetestDetailsByCustomerIdAndTestId(custid, testid);
				if(lst.isEmpty())
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.NOT_FOUND);
								}
				else
								{
										return new ResponseEntity<List<TestDetails>>(lst,HttpStatus.FOUND);
								}
				
				
	}
	@GetMapping("printallTestDetails")
	public ResponseEntity<List<TestDetails>> printAllTestDetails()
	{
	List<TestDetails> cust=tdserv.getallTestDetails();
	if(cust.isEmpty())
	{

	return new ResponseEntity<List<TestDetails>>(cust,HttpStatus.NOT_FOUND);
	}
	else
	{

	return new ResponseEntity<List<TestDetails>>(cust,HttpStatus.OK);
	}
	}
	
	
	@GetMapping("printTestDetailsbyTestId")
	public ResponseEntity<List<TestDetails>> printAllTestDetails1()
	{
	List<TestDetails> cust=tdserv.getallTestDetails();
	if(cust.isEmpty())
	{

	return new ResponseEntity<List<TestDetails>>(cust,HttpStatus.NOT_FOUND);
	}
	else
	{

	return new ResponseEntity<List<TestDetails>>(cust,HttpStatus.OK);
	}
	}
	
	@GetMapping("gettestDetailsofCustomer")
	public ResponseEntity<List<TestDetails>> gettestDetailsofCustomer(HttpServletRequest request)
	{
		Customer c=(Customer) request.getSession().getAttribute("custuser");
		
		List<TestDetails> td=tdserv.getTestDetailsByCustomerId(c.getCustomerId());
		if(td.isEmpty())
		{

		return new ResponseEntity<List<TestDetails>>(td,HttpStatus.NOT_FOUND);
		}
		else
		{

		return new ResponseEntity<List<TestDetails>>(td,HttpStatus.OK);
		}
	}
	
	@GetMapping("selectTestDetailsid/{id}")
	public ResponseEntity<TestDetails> getTestDetails(@PathVariable("id") int id,HttpServletRequest request)
	
	{
		TestDetails td=tdserv.getTestDetailsById(id);
		request.getSession().setAttribute("testtdtest", td);
	
		if(td!=null)
		{

		return new ResponseEntity<TestDetails>(td,HttpStatus.FOUND);
		}
		else
		{

		return new ResponseEntity<TestDetails>(td,HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping("getBillAmount")
	public ResponseEntity<Integer> getbillamount(HttpServletRequest request)
	{
		TestDetails td=(TestDetails) request.getSession().getAttribute("testtdtest");
		int amount=tdserv.getfindamount(td);
		
		return new ResponseEntity<Integer>(amount,HttpStatus.FOUND);
		
			
		}
		
	
}
