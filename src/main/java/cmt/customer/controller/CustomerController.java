package cmt.customer.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





import cmt.customer.model.Customer;
import cmt.customer.service.CustomerService;



@RestController
public class CustomerController {

@Autowired
CustomerService ser;

Logger logger=LoggerFactory.getLogger(CustomerController.class);


@PostMapping("addCustomer")
public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer a)
{
Customer c=ser.addCust(a);
if(c!=null)
{
logger.info("Sucessfully Added Customer Details");
return new ResponseEntity<Customer>(a,HttpStatus.ACCEPTED);
}
else
{
logger.error("Try again");
return new ResponseEntity<Customer>(a,HttpStatus.NOT_ACCEPTABLE);
}
}

@PutMapping("updateCustomer")
public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer a)
{
Customer c=ser.updateCust(a);
if(c!=null)
{
logger.info("Sucessfully Updated Customer Details");
return new ResponseEntity<Customer>(a,HttpStatus.ACCEPTED);
}
else
{
logger.error("Data Not Updated");
return new ResponseEntity<Customer>(a,HttpStatus.NOT_MODIFIED);
}
}




//this is for Admin
@DeleteMapping("AdmincustomerDelete/{customerId}")
public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") String customerId)
{
Customer cust=ser.deleteCust(customerId);
if(cust!=null)
{
logger.info("Sucessfully Delete Customer Details");
return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
}
else
{
logger.error("Data Not Deleted");
return new ResponseEntity<Customer>(cust,HttpStatus.NOT_FOUND);
}
}


//After login this is for Customer
@DeleteMapping("customerDelete")
public ResponseEntity<Customer> deleteCustomer(HttpServletRequest session)
{
Customer c=(Customer) session.getAttribute("custuser");
Customer cust=ser.deleteCust(c.getCustomerId());
if(cust!=null)
{
logger.info("Sucessfully Delete Customer Details");
return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
}
else
{
logger.error("Data Not Deleted");
return new ResponseEntity<Customer>(cust,HttpStatus.NOT_FOUND);
}
}


@GetMapping("printallCustomer")
public ResponseEntity<List<Customer>> getallCustomer()
{
List<Customer> cust=ser.printAllCustomer();
if(cust.isEmpty())
{
logger.info("Sucessfully print all data");
return new ResponseEntity<List<Customer>>(cust,HttpStatus.NOT_FOUND);
}
else
{
logger.error("Try again to print Data");
return new ResponseEntity<List<Customer>>(cust,HttpStatus.OK);
}
}



@GetMapping("printCustomer/{customerId}")
public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") String customerId)
{
Customer cust=ser.getById(customerId);

if(cust!=null)
{
logger.info("Sucessfully print Customer data");
return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
}
else
{
logger.error("Try again to print Data");
return new ResponseEntity<Customer>(cust,HttpStatus.NOT_FOUND);
}
}





//after login
@GetMapping("getCustomerName")
public ResponseEntity<Customer> getCustomerByName(HttpServletRequest session)
{
Customer c=(Customer) session.getAttribute("custuser");
Customer cust=ser.getByName(c.getCustomerName());
if(cust!=null)
{
logger.info("Sucessfully printed Customer data by using custName");
return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
}
else
{
logger.error("Try again to print Cust Data");
return new ResponseEntity<Customer>(cust,HttpStatus.NOT_FOUND);
}
}




@GetMapping("customerlogin")
public ResponseEntity<Customer> CustomerLogin( @RequestBody Customer c,HttpServletRequest request)
{
Customer cust=ser.checkCustomerLogin(c.getCustomerId(), c.getCustomerPassword());
request.getSession().setAttribute("custuser", cust);

if(cust!=null)
{
logger.info("Sucessfully Login");
return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
}
else
{
logger.error("Try again");
return new ResponseEntity<Customer>(cust,HttpStatus.NOT_FOUND);
}
}
}