package cmt.testdetails.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmt.admin.exception.EmptyListException;
import cmt.customer.model.Customer;
import cmt.store.model.TestStoreDetails;
import cmt.test.model.Test;
import cmt.testdetails.dao.TestDetailsDao;
import cmt.testdetails.model.TestDetails;

@Service
public class TestDetailsService implements ITestDetailsService {
	@Autowired
	TestDetailsDao dao;
	@Autowired
	private Test t1;

	@Override
	@Transactional
	public TestDetails addTestDetails(TestDetails td) {

		TestDetails t = dao.save(td);

		return t;
	}

	@Override
	public TestDetails updateTestDetails(TestDetails td) {
		TestDetails t = dao.findById(td.getTestDetailsId()).get();

		t.setAppointmentDate(td.getAppointmentDate());
		t.setTypeOfService(td.getTypeOfService());
		dao.save(td);
		return td;
	}

	@Override
	@Transactional
	public List<TestDetails> deleteTestDetailsByCustId(String customerId) {
// TODO Auto-generated method stub
		List<TestDetails> t = dao.deleteByCusCustomerId(customerId);
		if (t.isEmpty()) {
			throw new EmptyListException("607", "List is empty");
		}

		return t;
	}

	@Override
	@Transactional
	public List<TestDetails> deleteTestDetailsByTestId(int testId) {
		List<TestDetails> t = dao.deleteByTestPlaceTestId(testId);
		return t;
	}

	@Override
	@Transactional
	public List<TestDetails> getTestDetailsByCustomerId(String customerId) {
		List<TestDetails> t = dao.findByCusCustomerId(customerId);
		if (t.isEmpty()) {
			throw new EmptyListException("607", "List is empty");
		}
		return t;
	}

	@Override

	public List<TestDetails> getTestDetailsByTestId(int testId) {
		List<TestDetails> t = dao.findByTestPlaceTestId(testId);
		if (t.isEmpty()) {
			throw new EmptyListException("607", "List is empty");
		}
		return t;
	}

	@Override
	public List<TestDetails> getallTestDetails() {
		List<TestDetails> list = new ArrayList<TestDetails>();
		Iterable<TestDetails> li = dao.findAll();
		for (TestDetails tl : li) {
			list.add(tl);
		}
		if (list.isEmpty()) {
			throw new EmptyListException("607", "List is Empty");
		}
		return list;
	}

	@Override
	@Transactional
	public List<TestDetails> deletetestDetailsByCustomerIdAndTestId(String customerId, int TestId) {
		List<TestDetails> t = dao.deleteByCusCustomerIdAndTestPlaceTestId(customerId, TestId);
		if (t.isEmpty()) {
			throw new EmptyListException("607", "list is empty");
		}
		return t;
	}

	@Override
	@Transactional
	public TestDetails deleteTestdetails(int testDetailsId) {
		TestDetails t = dao.findById(testDetailsId).get();// nosuchelementException
		return t;
	}

	@Override
	@Transactional
	public TestDetails getTestDetailsById(int testDetailsId) {
		TestDetails t = dao.findById(testDetailsId).get();// nosuchelementException
		return t;
	}

	@Override
	public TestDetails getTestbytestid(int testdetailsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getfindamount(TestDetails t) {
		// TODO Auto-generated method stub
		int billamount = 0;
		TestDetails td = dao.findById(t.getTestDetailsId()).get();
		List<TestStoreDetails> l = td.getTest();
		Iterator<TestStoreDetails> l1 = l.iterator();
		while (l1.hasNext()) {
			billamount = (int) (billamount + (l1.next().getTestPrice()));
		}

		if (td.getTypeOfService().equals("home")) {
			billamount = billamount + 200;
		}

		return billamount;
	}

}