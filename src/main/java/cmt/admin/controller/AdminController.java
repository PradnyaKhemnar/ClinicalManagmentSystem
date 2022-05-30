package cmt.admin.controller;

import java.util.List;

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



import cmt.admin.model.Admin;
import cmt.admin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminserv;
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	
	@PostMapping("signup")
	public ResponseEntity<Admin> addUser( @Valid @RequestBody Admin ad)
	{
		Admin l=adminserv.addadminDetails(ad);
		if(l!=null)
		{
			logger.info("successfully added");
			return new ResponseEntity<Admin>(l,HttpStatus.ACCEPTED);
		}
		else
		{
			logger.error("not added");
			return new ResponseEntity<Admin>(l,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("updateAdmin")
	public ResponseEntity<Admin> updateadmin(@Valid @RequestBody Admin a)
	{
		Admin l=adminserv.updateAdmin(a);
		if(l!=null)
		{
			logger.info("successfully updated");
			return new ResponseEntity<Admin>(l,HttpStatus.ACCEPTED);
		}
		else
		{
			logger.error("not updated");
			return new ResponseEntity<Admin>(l,HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("adminDelete/{AdminId}")
	public ResponseEntity<Admin> deleteadmin(@PathVariable("AdminId") int AdminId)
	{
		Admin l=adminserv.deleteAdmin(AdminId);
		if(l!=null)
		{
			logger.info("successfully deleted");
			return new ResponseEntity<Admin>(l,HttpStatus.FOUND);
		}
		else
		{
			logger.error("not updated");
			return new ResponseEntity<Admin>(l,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("printallAdmin")
	public ResponseEntity<List<Admin>> getallAdmin()
	{
		List<Admin> lst=adminserv.getAdmin();
		if(lst.isEmpty())
		{
			logger.error("empty list");
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
			
		}
		else
		{
			logger.info("successfully retrieved");
			return new ResponseEntity<List<Admin>>(lst,HttpStatus.OK);
		}
		
	}

	@GetMapping("printAdmin/{AdminId}")
	public ResponseEntity<Admin> getadmin(@PathVariable("AdminId") int adminId)
	{
		Admin l=adminserv.getById(adminId);
		if(l!=null)
		{
			logger.info("successfully retrieved");
			return new ResponseEntity<Admin>(l,HttpStatus.FOUND);
		}
		else
		{
			logger.error("empty data");
			return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("adminlogin")
	public ResponseEntity<Admin> userAdminLogin(String username,String password)
	{
		Admin l=adminserv.checkAdminLogin(username, password);
		if(l!=null)
		{
			logger.info("successfully logged in");
			return new ResponseEntity<Admin>(l,HttpStatus.FOUND);
		}
		else
		{
			logger.error("not logged in...invalid data");
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		
	}
	
			

	
}


	


