package cmt.report.controller;

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

import cmt.customer.controller.CustomerController;
import cmt.customer.model.Customer;
import cmt.report.model.Report;
import cmt.report.service.ReportService;
import cmt.store.doa.TestStoreDao;
import cmt.store.model.TestStoreDetails;
import cmt.store.service.TestStoreDetailsService;

@RestController
public class ReportController {
	@Autowired
	ReportService ser;
	@Autowired
	private TestStoreDetailsService tdserv;

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("pos/{placedid}")
	public ResponseEntity<Report> addReport(@PathVariable("placedid") int id, @RequestBody Report a) {

		TestStoreDetails t = tdserv.printTStoredData(id);
		t.setRep(a);
		TestStoreDetails t1 = tdserv.updateStoredData(t);

		if (a != null) {
			logger.info("Sucessfully Added Report Details");
			return new ResponseEntity<Report>(a, HttpStatus.ACCEPTED);
		} else {
			logger.error("Try again");
			return new ResponseEntity<Report>(a, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("updateReport")
	public ResponseEntity<Report> updateCustomer(@Valid @RequestBody Report a) {
		Report c = ser.updateReport(a);
		if (c != null) {
			logger.info("Sucessfully Updated Report Details");
			return new ResponseEntity<Report>(a, HttpStatus.ACCEPTED);
		} else {
			logger.error("Data Not Updated");
			return new ResponseEntity<Report>(a, HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("DeleteReport/{Reportid}")
	public ResponseEntity<Report> deleteCustomer(@PathVariable("Reportid") int reportid) {
		Report cust = ser.DeleteReport(reportid);
		if (cust != null) {
			logger.info("Sucessfully Delete Report Details");
			return new ResponseEntity<Report>(cust, HttpStatus.FOUND);
		} else {
			logger.error("Data Not Deleted");
			return new ResponseEntity<Report>(cust, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("getReportByReportId/{Reportid}")
	public ResponseEntity<Report> printreportbyreportid(@PathVariable("Reportid") int ReportId) {
		Report cust = ser.getReportByReportId(ReportId);
		if (cust != null) {
			logger.info("Sucessfully print all data");
			return new ResponseEntity<Report>(cust, HttpStatus.FOUND);
		} else {
			logger.error("Try again to print Data");
			return new ResponseEntity<Report>(cust, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("getreportByTestDetailsId/{TestDetailsId}")
	public ResponseEntity<Report> printreportbyTestdetailsid(@PathVariable("TestDetailsId") int TestDetailsId) {
		Report cust = ser.getreportByPlacedId(TestDetailsId);
		if (cust != null) {
			logger.info("Sucessfully print all data");
			return new ResponseEntity<Report>(cust, HttpStatus.FOUND);
		} else {
			logger.error("Try again to print Data");
			return new ResponseEntity<Report>(cust, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("printallReports")
	public ResponseEntity<List<Report>> getallReports() {
		List<Report> cust = ser.getallReports();
		if (cust.isEmpty()) {
			logger.info("Sucessfully print all data");
			return new ResponseEntity<List<Report>>(cust, HttpStatus.NOT_FOUND);
		} else {
			logger.error("Try again to print Data");
			return new ResponseEntity<List<Report>>(cust, HttpStatus.OK);
		}
	}
}