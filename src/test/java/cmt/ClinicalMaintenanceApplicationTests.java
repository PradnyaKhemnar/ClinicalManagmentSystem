package cmt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cmt.admin.dao.AdminDao;
import cmt.admin.model.Admin;
import cmt.customer.dao.CustomerDao;
import cmt.customer.model.Customer;
import cmt.report.dao.ReportDao;
import cmt.report.model.Report;
import cmt.store.doa.TestStoreDao;
import cmt.store.model.TestStoreDetails;
import cmt.store.service.TestStoreDetailsService;
import cmt.test.dao.TestDao;
import cmt.testdetails.dao.TestDetailsDao;
import cmt.testdetails.model.TestDetails;

@SpringBootTest
class ClinicalMaintenanceApplicationTests {
	@Autowired
	TestStoreDetailsService tss;

	@Autowired
	private CustomerDao dao;

	@Autowired
	private AdminDao adao;

	@Autowired
	private TestDao tdao;

	@Autowired
	private TestDetailsDao tddao;

	@Autowired
	private TestStoreDao storedao;

	@Autowired
	private ReportDao rdao;

	@Test
	void contextLoads() {
	}

	@Test
	void deletefromtable() {
		tss.deletebytesdetailsid(5);
	}

	@Test
	@Order(1)
	public void testaddCustomer() {
		Customer c = new Customer();
		c.setCustomerId("C101");
		c.setCustomerName("Pradnya");
		c.setCustomerMobileNumber(1254789632);
		c.setCustomerEmail("prad@gmmail.com");
		c.setCustomerAddress("pune");
		c.setCustomerPassword("pass@123");
		dao.save(c);
	}

	@Test
	@Order(9)
	public void testaddCustomer1() {
		Customer c = new Customer();
		c.setCustomerId("C102");
		c.setCustomerName("Pra");
		c.setCustomerMobileNumber(1254789632);
		c.setCustomerEmail("prad@gmmail.com");
		c.setCustomerAddress("pune");
		c.setCustomerPassword("pass@123");
		dao.save(c);
	}

	@Test
	@Order(2)
	public void testGetAllCustomers() {
		List<Customer> lt = dao.findAll();
		assertThat(lt.size()).isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testDeleteCustomerId() {
		Customer t = dao.findById("C102").get();
		dao.delete(t);
		assertThat(dao.existsById("C102")).isFalse();
	}

	@Test
	@Order(4)
	public void testgetcustId() {
		Customer t = dao.findById("C101").get();
		assertEquals("C101", t.getCustomerId());

	}

	@Test
	@Order(5)
	public void testupdateCustomer() {
		Customer c = dao.findById("C101").get();
		c.setCustomerName("prad");
		c.setCustomerMobileNumber(224789632);
		c.setCustomerEmail("prad@gmmail.com");
		c.setCustomerAddress("pune");
		c.setCustomerPassword("pass@1");
		dao.save(c);
		assertEquals("prad", c.getCustomerName());
	}

	@Test
	@Order(6)
	public void testCustomerLogin() {
		Customer c = dao.findByCustomerIdAndCustomerPassword("C101", "password");
	}

	@Test
	@Order(7)
	public void testGetCustomerName() {
		Customer c = dao.findByCustomerName("pradnya");

	}

	@Test
	@Order(8)
	public void testCustomerDelete() {
		Customer c = dao.getById("C101");
		dao.delete(c);
		assertThat(dao.existsById("C101")).isFalse();
	}

	@Test
	@Order(10)
	public void testaddAdmin() {
		Admin a = new Admin();
		a.setAdminId(1);
		a.setAdminName("Admin");
		a.setMobilenumber(1254789632);
		a.setAdminEmail("admin@gmail.com");
		a.setAdminAddress("Pune");
		a.setAdminUserName("admin");
		a.setAdminPassword("admin123");
		adao.save(a);
	}

	@Test
	@Order(11)
	public void testupdateAdmin() {
		Admin a = adao.findById(2).get();
		a.setAdminName("adminkh");
		a.setMobilenumber(1254789632);
		a.setAdminEmail("admin@gmail.com");
		a.setAdminAddress("Pune");
		a.setAdminUserName("admin");
		a.setAdminPassword("admin123");
		adao.save(a);
		assertEquals("adminkh", a.getAdminName());
	}

	@Test
	@Order(12)
	public void testDeleteAdminId() {
		Admin t = adao.findById(1).get();
		adao.delete(t);
		assertThat(adao.existsById(1)).isFalse();
	}

	@Test
	@Order(13)
	public void testPrintAllCustomers() {
		List<Admin> lt = adao.findAll();
		assertThat(lt.size()).isGreaterThan(0);
	}

	@Test
	@Order(14)
	public void testprintdatabyadminid() {
		Admin t = adao.findById(2).get();
		assertEquals(2, t.getAdminId());
	}

	@Test
	@Order(15)
	public void testAdminLogin() {
		Admin c = adao.findByAdminUserNameAndAdminPassword("admin", "admin123");
	}

	@Test
	@Order(17)
	public void testPrintAllTestDetails() {
		List<TestDetails> lt = tddao.findAll();
		assertThat(lt.size()).isGreaterThan(0);
	}

	@Test
	@Order(18)
	public void testprintdatabyTestDetailsid() {
		TestDetails t = tddao.findById(1).get();
		assertEquals(1, t.getTestDetailsId());
	}

	@Test
	@Order(19)
	public void testprintTestDetailsByCustId() {
		List<TestDetails> d = tddao.findByCusCustomerId("C101");
	}

	@Test
	@Order(19)
	public void testprintTestDetailsByTestId() {
		List<TestDetails> d = tddao.findByTestPlaceTestId(1);
	}

	@Test
	@Order(20)
	public void testaddTesttStore() {
		TestStoreDetails td = new TestStoreDetails();
		td.setPlaceTestId(3);
		td.setTestName("Cancer");
		td.setTestType("Blood");
		td.setTestPrice(1500);
		storedao.save(td);
	}

	@Test
	@Order(21)
	public void testupdateStoredData() {
		TestStoreDetails td = storedao.findById(3).get();
		td.setTestName("Thyroid");
		td.setTestType("Blood");
		td.setTestPrice(1500);
		storedao.save(td);
		assertEquals("Thyroid", td.getTestName());
	}

	@Test
	@Order(23)
	public void testprintdatabyplacingid() {
		TestStoreDetails t = storedao.findById(1).get();
		assertEquals(1, t.getPlaceTestId());
	}

	@Test
	@Order(24)
	public void testPrintAllTestStoreData() {
		List<TestStoreDetails> lt = storedao.findAll();
		assertThat(lt.size()).isGreaterThan(0);
	}

	@Test
	@Order(25)
	public void testupdateReport() {
		Report td = rdao.findById(1).get();
		td.setTestResult("Negative");
		rdao.save(td);

	}

	@Test
	@Order(27)
	public void testPrintAllReport() {
		List<Report> lt = rdao.findAll();
		assertThat(lt.size()).isGreaterThan(0);
	}

	@Test
	@Order(28)
	public void testprintdatabyReportid() {
		Report t = rdao.findById(2).get();
		assertEquals(2, t.getReportid());
	}

}
