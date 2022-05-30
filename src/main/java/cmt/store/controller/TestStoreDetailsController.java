package cmt.store.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import cmt.store.model.TestStoreDetails;
import cmt.store.service.TestStoreDetailsService;
import cmt.test.controller.TestController;
import cmt.test.model.Test;
import cmt.test.service.TestService;
import cmt.testdetails.model.TestDetails;
import cmt.testdetails.service.TestDetailsService;

@RestController
public class TestStoreDetailsController {
	
	@Autowired
	TestStoreDetailsService tstore;
	@Autowired
	TestService testserv;
	Logger logger=LoggerFactory.getLogger(TestController.class);
	
	@PostMapping("StoreData")
	public ResponseEntity<TestStoreDetails> addTest(@RequestBody TestStoreDetails t,HttpServletRequest request)//through requestbody
	{
		TestDetails td=(TestDetails) request.getSession().getAttribute("testtdtest");

		System.out.println(td);
		
		Test t2=testserv.finbytest1name(t.getTestName());
		
		
		t.setTestPrice(t2.getTestPrice());
		t.setTestType(t2.getTestType());
		td.getTest().add(t);
		
		t.setTes(td);
		
		TestStoreDetails stored=tstore.storeDat(t);
	
		

	if(stored!=null)
	{
	logger.info("Adding test is succesfull");
	return new ResponseEntity<TestStoreDetails>(stored,HttpStatus.CREATED);



	}
	else
	{
	logger.error("login is not created");
	return new ResponseEntity<TestStoreDetails>(stored,HttpStatus.NOT_ACCEPTABLE);



	}
	}
	@PutMapping("updateStoredData/{storedDataId}")
	
	public ResponseEntity<TestStoreDetails> updateStoredData( @RequestBody TestStoreDetails t)
	{
	TestStoreDetails t1=tstore.updateStoredData(t);

	if(t1!=null)
	{
	logger.info("Test updated succesfully");
	return new ResponseEntity<TestStoreDetails>(t1,HttpStatus.CREATED);



	}
	else
	{
	logger.error("Test is not updated");
	return new ResponseEntity<TestStoreDetails>(t1,HttpStatus.NOT_MODIFIED);



	}
	}
	
	@DeleteMapping("deleteStoredData/{testId}")
	public ResponseEntity<TestStoreDetails> deleteTest(@PathVariable("testId") int testId)
	{
	TestStoreDetails t1=tstore.deleteStoredData(testId);

	if(t1!=null)
	{
	logger.info("test deleted succesfully");
	return new ResponseEntity<TestStoreDetails>(t1,HttpStatus.OK);



	}
	else
	{
	logger.error("test is not deleted");
	return new ResponseEntity<TestStoreDetails>(t1,HttpStatus.NOT_FOUND);



	}
	}




	@GetMapping("printStoredData/{testId}")



	public ResponseEntity<TestStoreDetails> printTest( @PathVariable("testId") int testId)
	{
	TestStoreDetails t1=tstore.printTStoredData(testId);

	if(t1!=null)
	{
	logger.info("Test updated succesfully");
	return new ResponseEntity<TestStoreDetails>(t1,HttpStatus.FOUND);



	}
	else
	{
	logger.error("Test is not updated");
	return new ResponseEntity<TestStoreDetails>(t1,HttpStatus.NOT_FOUND);



	}
	}



	@GetMapping("printallStoredTestData")
	public ResponseEntity<List<TestStoreDetails>> getallTest()
	{
		List<TestStoreDetails> test=tstore.allTestStoreData();
	if(test.isEmpty())
	{
	return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.NOT_FOUND);
	}
	else
	{
	return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.OK);
	}

	}

	@GetMapping("printByTestDetailsId/{id}")
	public ResponseEntity<List<TestStoreDetails>> getallReportBytestDetailsID(@PathVariable("id") int tes)
	{
		List<TestStoreDetails> test=tstore.findbytesdetailsId(tes);
	if(test!=null)
	{
	return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.NOT_FOUND);
	}
	else
	{
	return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.OK);
	}
	}
	
	@GetMapping("printcurrenttestdetailsdata")
	public ResponseEntity<List<TestStoreDetails>> getallReportBytestDetailsIDbycutsomer(HttpServletRequest request)
	{
		TestDetails td=(TestDetails) request.getSession().getAttribute("testtdtest");
	
		List<TestStoreDetails> test=tstore.findbytesdetailsId(td.getTestDetailsId());
	if(test!=null)
	{
	return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.NOT_FOUND);
	}
	else
	{
	return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.OK);
	}

	}

	@DeleteMapping("DeleteStoreDetailsForTestDetailsId")
	public ResponseEntity<List<TestStoreDetails>> deleteTestdetailsinstoredtable(HttpServletRequest request)
	{
		TestDetails td=(TestDetails) request.getSession().getAttribute("testtdtest");
		List<TestStoreDetails> test=tstore.deletebytesdetailsid(td.getTestDetailsId());
		if(test.isEmpty())
		{
		return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<List<TestStoreDetails>>(test,HttpStatus.NOT_FOUND);
		}
		
	}
	
}


