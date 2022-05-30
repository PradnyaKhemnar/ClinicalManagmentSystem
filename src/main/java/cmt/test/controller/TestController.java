package cmt.test.controller;



import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;




import cmt.test.model.Test;



import cmt.test.service.TestService;
import cmt.testdetails.model.TestDetails;
import cmt.testdetails.service.TestDetailsService;



@RestController
public class TestController {
@Autowired
TestService ts;
@Autowired
private TestDetailsService ds;
Logger logger=LoggerFactory.getLogger(TestController.class);


@PostMapping("addtest1")
public ResponseEntity<Test> addTest1(@Valid @RequestBody Test t)//through requestbody
{
	
	Test t1=ts.addTest(t);

if(t1!=null)
{
logger.info("Adding test is succesfull");
return new ResponseEntity<Test>(t1,HttpStatus.CREATED);



}
else
{
logger.error("login is not created");
return new ResponseEntity<Test>(t1,HttpStatus.NOT_ACCEPTABLE);



}}


/*
 * @PostMapping("addTest")
 * 
 * 
 * 
 * public ResponseEntity<Test> addTest(@RequestBody Test t,HttpServletRequest
 * request)//through requestbody { TestDetails td=(TestDetails)
 * request.getSession().getAttribute("testtdtest"); System.out.println(td);
 * 
 * Test t2=ts.finbytest1name(t.getTestName());
 * 
 * 
 * t.setTestPrice(t2.getTestPrice()); t.setTestType(t2.getTestType());
 * 
 * 
 * ts.addTest(t); ds.addTestDetails(td);
 * 
 * 
 * if(t!=null) { logger.info("Adding test is succesfull"); return new
 * ResponseEntity<Test>(t,HttpStatus.CREATED);
 * 
 * 
 * 
 * } else { logger.error("login is not created"); return new
 * ResponseEntity<Test>(t,HttpStatus.NOT_ACCEPTABLE);
 * 
 * 
 * 
 * }}
 */


@PutMapping("updateTest")



public ResponseEntity<Test> updateTest(@Valid @RequestBody Test t)
{
Test t1=ts.updateTest(t);

if(t1!=null)
{
logger.info("Test updated succesfully");
return new ResponseEntity<Test>(t1,HttpStatus.CREATED);



}
else
{
logger.error("Test is not updated");
return new ResponseEntity<Test>(t1,HttpStatus.NOT_MODIFIED);



}
}
@DeleteMapping("deleteTest/{testId}")



public ResponseEntity<Test> deleteTest(@PathVariable("testId") int testId)
{
Test t1=ts.deleteTest(testId);

if(t1!=null)
{
logger.info("test deleted succesfully");
return new ResponseEntity<Test>(t1,HttpStatus.OK);



}
else
{
logger.error("test is not deleted");
return new ResponseEntity<Test>(t1,HttpStatus.NOT_FOUND);



}
}




@GetMapping("printTest/{testId}")



public ResponseEntity<Test> printTest( @PathVariable("testId") int testId)
{
Test t1=ts.printTest(testId);

if(t1!=null)
{
logger.info("Test updated succesfully");
return new ResponseEntity<Test>(t1,HttpStatus.FOUND);



}
else
{
logger.error("Test is not updated");
return new ResponseEntity<Test>(t1,HttpStatus.NOT_FOUND);



}
}



@GetMapping("printallTest")
public ResponseEntity<List<Test>> getallTest()
{List<Test> test=ts.allTest();
if(test.isEmpty())
{
return new ResponseEntity<List<Test>>(test,HttpStatus.NOT_FOUND);
}
else
{
return new ResponseEntity<List<Test>>(test,HttpStatus.OK);
}




}
@GetMapping("dd")
public ResponseEntity<Double> setaa()
{
	Test t=ts.deleteTest(0);
	return new ResponseEntity<Double>(t.getTestPrice(),HttpStatus.OK);
	
	
}

}
